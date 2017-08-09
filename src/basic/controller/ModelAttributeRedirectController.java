package basic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用來測試以下Controller使用
 * 1.ModelAttribute1Controller: http://localhost:8980/coreyou.springMVC/modelAttributeTest1 (會開啟modelAttributeTest1.jsp)
 * 2.ModelAttribute2Controller: http://localhost:8980/coreyou.springMVC/modelAttributeTest2 (會開啟modelAttributeTest2.jsp)
 * 3.ModelAttribute3Controller: http://localhost:8980/coreyou.springMVC/modelAttributeTest3 (會開啟modelAttributeTest3.jsp)
 * 
 * @author coreyou
 *
 */
@Controller
public class ModelAttributeRedirectController {
	
	private static final Log logger = LogFactory.getLog(ModelAttributeRedirectController.class);
	
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		logger.info("loginForm(" + formName + ")");
		
		return formName;
	}
}
