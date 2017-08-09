package basic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import basic.model.Book;

/**
 * 開啟http://localhost:8980/coreyou.springMVC/jsonRequest.jsp測試，
 * 會使用ajax傳送JSON字串到setJson()，
 * 再將JSON物件印到console與回傳到前端
 * 
 * 注意：
 * 1. build path中jackson-core、jackson-databind、jackson-mapper-asl要和Spring的jar放在同一包裡面，如果沒有放在同一個包裡，會導致http 415錯誤，型態不支援。
 * 2. 前端header如果沒有指定Accept，會導致http 415錯誤，型態不支援。
 * 
 * @author coreyou
 *
 */
@Controller
@RequestMapping(value="/json")
public class JsonRequestController {

	private static final Log logger = LogFactory.getLog(JsonRequestController.class);
	
	@RequestMapping(value="/testRequestBody", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void setJson(@RequestBody Book book, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			logger.info(mapper.writeValueAsString(book));
			book.setAuthor("你是誰");
			response.setContentType("applicaion/json;charset=utf-8");
			response.getWriter().println(mapper.writeValueAsString(book));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getJson() {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1, "Spring tutor", "coreyou"));
		list.add(new Book(1, "Spring tutor2", "coreyou"));
		return list;
	}
}
