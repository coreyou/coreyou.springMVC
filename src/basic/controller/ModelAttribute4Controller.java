package basic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 開啟 localhost:8980/coreyou.springMVC/modelAttributeTest4Result 測試
 * 
 * @author coreyou
 *
 */
@Controller
public class ModelAttribute4Controller {
	private static final Log logger = LogFactory.getLog(ModelAttribute4Controller.class);
	
	/**
	 * model新增一個屬性 userName，值為"admin"
	 * 
	 * @return
	 */
	@RequestMapping(value="/modelAttributeTest4Result")
	@ModelAttribute(value="userName")
	public String login4() {
		logger.info("login4()");
		
		return "admin";
	}
}
