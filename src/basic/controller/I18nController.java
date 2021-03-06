package basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import basic.model.User;

/**
 * 測試方法
 * 1. http://localhost:8980/coreyou.springMVC/i18n/i18nTestForm 會經由loginForm()的RequestMapping開啟i18nTestForm.jsp
 * 2. 輸入coreyou 123456按下送出
 * 3. 會經由login()判斷成功登入而顯示i18nTestSuccess.jsp
 * 
 * springConfig.xml要設定org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver。
 * 多國語系資源檔在resources資料夾下面。
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/i18n")
public class I18nController {
	
	/**
	 * 使用這個方法來開啟 i18nTestForm.jsp 測試登入頁面
	 * 
	 * @param formName
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName, Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return formName;
	}
	
	/**
	 * 帳號coreyou、密碼123456就會成功轉導到i18nTestSuccess.jsp
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
