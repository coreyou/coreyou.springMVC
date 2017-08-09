package basic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.測試使用URL傳進參數(@PathVariable)
 * 2.測試使用header傳進參數(@requestHeaderTest)
 * 3.測試使用cookie傳進參數(@CookieValue)
 * 
 * @author coreyou
 *
 */
@Controller
public class DataBindingController {
	private static final Log logger = LogFactory.getLog(DataBindingController.class);
	
	/**
	 * http://localhost:8980/coreyou.springMVC/dataBindingTest
	 * 開啟測試JSP，以測試以下三個方法
	 * 
	 * @return
	 */
	@RequestMapping(value="/dataBindingTest")
	public String dataBindingTest() {
		return "dataBindingTest";
	}
	/**
	 * http://localhost:8980/coreyou.springMVC/pathVariableTest/anyName 
	 * 測試@PathVariable
	 * 
	 * @param userId
	 */
	@RequestMapping(value="/pathVariableTest/{userId}")
	public void pathVariableTest(@PathVariable String userId) {
		logger.info("透過@PathVariable取得資料: " + userId);
	}
	
	/**
	 * http://localhost:8980/coreyou.springMVC/requestHeaderTest
	 * 測試@requestHeaderTest
	 * 
	 * @param userAgent
	 * @param accepts
	 */
	@RequestMapping(value="/requestHeaderTest")
	public void requestHeaderTest(@RequestHeader("User-Agent") String userAgent/*, @RequestHeader("value=Accept") String[] accepts*/) {
		logger.info("透過@requestHeaderTest取得資料: " + userAgent);
		/*
		for(String accept: accepts) {
			logger.info(accept);
		}
		*/
	}
	
	/**
	 * http://localhost:8980/coreyou.springMVC/cookieValueTest
	 * 測試@CookieValue
	 * 
	 * @param sessionId
	 */
	@RequestMapping(value="/cookieValueTest")
	public void cookieValueTest(@CookieValue(value="JSESSIONID", defaultValue="") String sessionId) {
		logger.info("透過@CookieValue取得資料: " + sessionId);
	}
}
