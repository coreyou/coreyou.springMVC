package websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	/**
	 * 接收/app/websocketHelloWorld送來的訊息，轉發到/topic/notice客戶端
	 * 
	 * @param greeting
	 * @return
	 */
	@MessageMapping("/websocketHelloWorld")
	@SendTo("/topic/notice")
	public String handle(String greeting) {
		return greeting;
	}
	
	@RequestMapping("/htmlHelloWorld")
	public String index() {
		return "index";
	}
}
