package basic.controller;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import basic.converter.DateEditor;
import basic.model.User;

/**
 * 測試方法
 * 1. http://localhost:8980/coreyou.springMVC/conversion/conversionTestForm 會經由loginForm()的RequestMapping開啟conversionTestForm.jsp
 * 2. 輸入欄位按下送出
 * 3. 顯示conversionSuccess.jsp
 * 
 * 使用了basic.converter.StringToDateConverter實作Converter，
 * 也將StringToDateConverter定義在springConfig.xml裡面
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/conversion")
public class ConversionController {
	private static final Log logger = LogFactory.getLog(ConversionController.class);
	
	/**
	 * 使用這個方法來開啟 conversionTestForm.jsp 測試登入頁面
	 * 
	 * @param formName
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		return formName;
	}
	
	/**
	 * 轉導到conversionTestSuccess.jsp
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute User user, Model model) {
		logger.info(user);
		model.addAttribute("user", user);
		
		return "conversionSuccess";
	}
	
	/**
	 * initBinder註解在controller初始化的時候註冊屬性編輯器
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
}
