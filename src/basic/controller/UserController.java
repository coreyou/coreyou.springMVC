package basic.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import basic.model.User;

/**
 * 1. http://localhost:8980/coreyou.springMVC/user/register GET registerForm()顯示註冊欄位，並輸入註冊資料POST register()
 * 2. http://localhost:8980/coreyou.springMVC/user/login 顯示登入欄位，如果輸入剛剛輸入的註冊帳號、密碼，則成功登入而顯示userWelcom.jsp 
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	private static List<User> userList;
	
	public UserController() {
		super();
		userList = new ArrayList<User>();
	}
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	/**
	 * 1. http://localhost:8980/coreyou.springMVC/user/register
	 * 2. userRegisterForm.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm() {
		logger.info("register GET method invoked");
		
		 return "userRegisterForm";
	}
	
	/**
	 * 1. http://localhost:8980/coreyou.springMVC/user/register
	 * 2. userLoginForm.jsp
	 * 
	 * @param userName
	 * @param password
	 * @param ip
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("ip") String ip) {
		logger.info("register POST method invoked");
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setIp(ip);
		
		userList.add(user);
		
		return "userLoginForm";
	}
	
	/**
	 * 1. http://localhost:8980/coreyou.springMVC/user/login
	 * 2. userLoginForm.jsp
	 * 
	 * @param userName
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
		logger.info("登入使用者:" + userName + " 密碼:" + password);
		
		for(User user: userList) {
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "userWelcome";
			}
		}
		return "userLoginForm";
	}
}
