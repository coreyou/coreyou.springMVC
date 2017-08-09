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
 * 開啟 http://localhost:8980/coreyou.springMVC/modelAttributeTest3 測試，輸入test 123456測試
 * (以上URL被定義在ModelAttributeRedirectController)
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/modelAttributeTest3")
public class ModelAttribute3Controller {
	private static final Log logger = LogFactory.getLog(ModelAttribute3Controller.class);
	
	private static List<User> userList;
	
	public ModelAttribute3Controller() {
		super();

		// 輸入的帳號密碼須符合這兩個帳號才會正常顯示
		userList = new ArrayList<User>();
		User user1 = new User("test", "123456", "測試用戶");
		User user2 = new User("test2", "789012", "測試用戶2");
		userList.add(user1);
		userList.add(user2);
	}
	
	public User find(String userName, String password) {
		logger.info("find(" + userName + ", " + password + ")");
		
		for(User user: userList) {
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * submit進來的時候，這個方法會先被呼叫，
	 * model的屬性名稱會直接使用User類別的user
	 * 
	 * @param userName
	 * @return
	 */
	@ModelAttribute
	public User userModel3(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		logger.info("userModel3(" + userName + ")");

		return find(userName, password);
	}
	
	/**
	 * 這個方法呼叫以前，會先呼叫userModel3()，
	 * 把參數的String userName當作屬性傳給model
	 * 
	 * @return
	 */
	@RequestMapping(value="/login3")
	public String login3() {
		logger.info("login3()");
		
		return "modelAttributeTest3Result";
	}
}
