package basic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 開啟 http://localhost:8980/coreyou.springMVC/modelAttributeTest1 測試
 * (以上URL被定義在ModelAttributeRedirectController)
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/modelAttributeTest1")
public class ModelAttribute1Controller {
	private static final Log logger = LogFactory.getLog(ModelAttribute1Controller.class);

	/**
	 * submit進來的時候，這個方法會先被呼叫，
	 * 使用參數來建立model的屬性
	 * 
	 * @param userName
	 * @return
	 */
	@ModelAttribute("userName")
	public String userModel1(@RequestParam("userName") String userName) {
		logger.info("userModel1(" + userName + ")");
		
		return userName;
	}
	
	/**
	 * 這個方法呼叫以前，會先呼叫userModel1()，
	 * 把參數的String userName當作屬性傳給model
	 * 
	 * @return
	 */
	@RequestMapping(value="/login1")
	public String login1() {
		logger.info("login1()");
		
		return "modelAttributeTest1Result";
	}
}
