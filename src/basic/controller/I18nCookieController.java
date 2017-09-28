package basic.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import basic.model.User;

/**
 * 測試方法
 * 1. http://localhost:8980/coreyou.springMVC/i18nCookie/i18nCookieTestForm 會經由loginForm()的RequestMapping開啟i18nCookieTestForm.jsp
 * 2. 輸入coreyou 123456按下送出
 * 3. 會經由login()判斷成功登入而顯示i18nCookieTestSuccess.jsp
 * 
 * springConfig.xml要設定org.springframework.web.servlet.i18n.CookieLocaleResolver。
 * 多國語系資源檔在resources資料夾下面。
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/i18nCookie")
public class I18nCookieController {
	
	/**
	 * 使用這個方法來開啟 i18nCookieTestForm.jsp 測試登入頁面
	 * 
	 * @param formName
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName, String requestLocale, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("requestLocale = " + requestLocale);
		
		if (requestLocale != null) {
			if ("zh_TW".equals(requestLocale)) {	// 設定中文
				Locale locale = new Locale("zh", "TW");
				(new CookieLocaleResolver()).setLocale(request, response, locale);
			} else if ("en_US".equals(requestLocale)) {	// 設定英文
				Locale locale = new Locale("en", "US");
				(new CookieLocaleResolver()).setLocale(request, response, locale);
			} else {	// 使用之前的設定
				(new CookieLocaleResolver()).setLocale(request, response, LocaleContextHolder.getLocale());
			}
		}
		
		User user = new User();
		model.addAttribute("user", user);
		
		return formName;
	}
	
	/**
	 * 帳號coreyou、密碼123456就會成功轉導到i18nCookieTestSuccess.jsp
	 * 
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/i18nLogin", method=RequestMethod.POST)
	public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request) {
		if (user.getUserName() != null && user.getUserName().equals("coreyou")
				&& user.getPassword() != null && user.getPassword().equals("123456")) {
			// 取得i18n的userName
			RequestContext requestContext = new RequestContext(request);
			String userName = requestContext.getMessage("userName");
			
			user.setUserName(userName);
			model.addAttribute("user", user);
			
			return "i18nTestSuccess";
		}
		
		return "error";
	}
}
