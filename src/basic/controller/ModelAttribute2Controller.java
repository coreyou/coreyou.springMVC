package basic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 開啟 http://localhost:8980/coreyou.springMVC/modelAttributeTest2 測試
 * (以上URL被定義在ModelAttributeRedirectController)
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/modelAttributeTest2")
public class ModelAttribute2Controller {
	private static final Log logger = LogFactory.getLog(ModelAttribute2Controller.class);

	/**
	 * submit進來的時候，這個方法會先被呼叫，
	 * 使用model.addAttribute建立model的屬性，
	 * 記得參數要有Model model
	 * 
	 * @param userName
	 * @return
	 */
	@ModelAttribute
	public void userModel2(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
		logger.info("userModel2(" + userName + ")");
		
		model.addAttribute("userName", userName);
		model.addAttribute("password", password);
	}
	
	/**
	 * 這個方法呼叫以前，會先呼叫userModel2()，
	 * 把參數的String userName當作屬性傳給model
	 * 
	 * @return
	 */
	@RequestMapping(value="/login2")
	public String login2() {
		logger.info("login2()");
		
		return "modelAttributeTest2Result";
	}
}
