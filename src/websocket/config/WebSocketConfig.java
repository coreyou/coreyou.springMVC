package websocket.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

//import websocket.handler.MyHandler;

/**
 * 實作WebSocketConfigurer以支援websocket
 * 實作WebSocketMessageBrokerConfigurer以支援STOMP
 * 
 * @author coreyou
 *
 */
@Configuration
@EnableWebMvc
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { // WebSocketConfigurer

//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		// 指定處理websocket的server路徑，且enable SockJS
//		registry.addHandler(myHandler(), "/myHandler").withSockJS()
//			.setStreamBytesLimit(512 * 1024)
//			.setHttpMessageCacheSize(1000)
//			.setDisconnectDelay(30 * 1000);
//	}
	
//	@Bean
//    public WebSocketHandler myHandler() {
//        return new MyHandler();
//    }

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 指定client端的路徑，/portfolio發出到/app的訊息會經由 message-handling methods處理
		config.setApplicationDestinationPrefixes("/app");
		// 指定client端的路徑，通常/topic用在多client端訂閱單一主題、/queue用在point-to-point的表現語意
        config.enableSimpleBroker("/topic", "/queue");
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 指定處理websocket的server路徑，且enable SockJS
		registry.addEndpoint("/portfolio").withSockJS();
	}

}
