package basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import basic.model.User;

/*
 * 1.先新增Gradle專案
 * 2.將缺少的檔案夾建出來
 * 	A. src/main/java
 *  B. src/main/webapp
 *  C. src/main/webapp/WEB-INF
 * 3.專案右鍵 >> properties >> project facets >> 開啟Dynamic Web Module
 * 4.專案右鍵 >> properties >> Deployment Assembly >> 指定src/main/java、src/main/webapp資料夾
 * 5.Deployment Assembly指定Java Build Entries
 * 
 */
/**
 * http://localhost:8980/coreyou.springMVC/basic/hello
 * 
 * 1.http://repo.springsource.org/libs-release-local/org/springframework/spring/4.3.7.RELEASE/ 下載spring framework
 * 2.建Dynamic web project
 * 3.設定build path和deployment assembly
 * 4.建web.xml
 * 5.建springmvcConfig.xml
 * 6.建HelloController
 * 7.建HelloView.jsp
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/basic")
public class HelloController {
	
	private static final Log logger = LogFactory.getLog(HelloController.class);

	/**
	 * http://localhost:8980/coreyou.springMVC/basic/hello
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/hello")
	public String hello(Model model) {
		logger.info("hello called");
		
		model.addAttribute("message", "Hello World");
		// 回傳HelloView，會和springConfig.xml裡面的prefix、suffix組成完整的路徑
		return "HelloView";
	}
	
	/**
	 * http://localhost:8980/coreyou.springMVC/basic/hello?myHello=myValue
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/hello", method=RequestMethod.GET, params="myHello=myValue")
	public String helloRequestMapping(Model model) {
		logger.info("helloRequestMapping called");
		
		model.addAttribute("message", "helloRequestMapping called");
		
		return "HelloView";
	}
	
	/**
	 * 和helloModel()是同一組的
	 * 也會影響helloModelMap()
	 * 
	 * @param ip
	 * @param password
	 * @param model
	 */
	@ModelAttribute
	public void helloModelAttribute(String ip, String password, Model model) {
		logger.info("hello modelAttribute");
		
		User user = new User();
		user.setIp(ip);
		user.setPassword(password);
		
		model.addAttribute("user", user);
	}
	
	/**
	 * http://localhost:8980/coreyou.springMVC/basic/helloModel?ip=testing&password=123456
	 * 會先進helloModelAttribute()，才回來helloModel()
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/helloModel")
	public String helloModel(Model model) {
		logger.info("hello model");
		
		User user = (User)model.asMap().get("user");
		System.out.println(user);
		user.setUserName("測試");
		
		return "HelloView";
	}
	
	/**
	 * 和helloModelMap()是一組的
	 * 
	 * @param ip
	 * @param password
	 * @param modelMap
	 */
	@ModelAttribute
	public void helloModelMapAttribute(String ip, String password, ModelMap modelMap) {
		logger.info("hello modelMapAttribute");
		
		User user2 = new User();
		user2.setIp(ip);
		user2.setPassword(password);
		
		modelMap.addAttribute("user2", user2);
	}

	/**
	 * http://localhost:8980/coreyou.springMVC/basic/helloModelMap?ip=testing&password=123457
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/helloModelMap")
	public String helloModelMap(ModelMap modelMap) {
		logger.info("hello modelMap");
		
		User user2 = (User)modelMap.get("user2");
		User user = (User)modelMap.get("user");
		System.out.println(user2);
		System.out.println(user);
		user2.setUserName("測試");
		user.setUserName("測試1");
		
		return "HelloView";
	}
	
	/**
	 * 和helloModelAndView()是一組的
	 * 
	 * @param ip
	 * @param password
	 * @param mv
	 */
	@ModelAttribute
	public void helloModelAndViewAttribute(String ip, String password, ModelAndView mv) {
		logger.info("hello ModelAndViewAttribute");
		
		User user3 = new User();
		user3.setIp(ip);
		user3.setPassword(password);
		
		mv.addObject("user3", user3);
	}
	
	/**
	 * http://localhost:8980/coreyou.springMVC/basic/helloModelAndView?ip=testing&password=123457
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/helloModelAndView")
	public ModelAndView helloModelAndView(ModelAndView mv) {
		logger.info("hello modelAndView");
		
		User user3 = (User)mv.getModel().get("user3");
		System.out.println(user3);
		user3.setUserName("測試2");
		
		mv.setViewName("HelloView");
		
		return mv;
	}
}
