package basic.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import basic.model.User;

/**
 * 開啟 http://localhost:8980/coreyou.springMVC/modelAttributeTest5 測試，
 * (以上URL被定義在ModelAttributeRedirectController)
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/modelAttributeTest5")
public class ModelAttribute5Controller {
	private static final Log logger = LogFactory.getLog(ModelAttribute5Controller.class);
	
	private static List<User> userList;
	
	/**
	 * submit進來的時候，這個方法會先被呼叫，
	 * model的屬性名稱會直接使用User類別的user
	 * 
	 * @param userName
	 * @return
	 */
	@ModelAttribute("user")
	public User userModel5(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		logger.info("userModel5(" + userName + ", " + password + ")");

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		return user;
	}
	
	/**
	 * 這個方法呼叫以前，會先呼叫userModel5()，
	 * 把參數的String userName當作屬性傳給model
	 * 
	 * @return
	 */
	@RequestMapping(value="/login5")
	public String login5(@ModelAttribute("user") User user) {
		logger.info("login5()");
		
		user.setIp("123.123.123.123");
		
		return "modelAttributeTest5Result";
	}
}
