package basic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import basic.model.User;

/**
 * 開啟 http://localhost:8980/coreyou.springMVC/sessionAttribute/userLoginForm 測試，
 * 會呼叫loginForm()方法，以開啟userLoginForm.jsp，
 * 輸入並送出帳號密碼以後會呼叫login()方法，寫入session，
 * 並轉導到userWelcome.jsp
 * 
 * @author coreyou
 *
 */
@Controller
@SessionAttributes("user")
@RequestMapping(value="/sessionAttribute")
public class SessionAttributeController {
	private static final Log logger = LogFactory.getLog(SessionAttributeController.class);
	
	/**
	 * http://localhost:8980/coreyou.springMVC/sessionAttribute/{formName}
	 * 
	 * @param formName
	 * @return
	 */
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		logger.info("loginForm(" + formName + ")");
		
		return formName;
	}
	
	/**
	 * http://localhost:8980/coreyou.springMVC/sessionAttribute/login
	 * 
	 * @param userName
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			Model model) {
		logger.info("login(" + userName + ", " + password + ")");
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setIp("33.33.33.33");
		
		model.addAttribute("user", user);
		return "userWelcome";
	}
}
