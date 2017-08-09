package basic.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import basic.model.Book;

/**
 * 開啟http://localhost:8980/coreyou.springMVC/xmlRequest.jsp測試，
 * 會使用ajax傳送XML字串到sendXML()，
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
@RequestMapping(value="/xml")
public class XmlRequestController {

	private static final Log logger = LogFactory.getLog(XmlRequestController.class);
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/sendXML", method=RequestMethod.POST)
	public void sendXML(@RequestBody Book book) {
		logger.info(book);
		logger.info("接收XML資料成功!");
	}

	@RequestMapping(value="/readXML", method=RequestMethod.POST)
	public @ResponseBody Book readXml() throws Exception {
		// 讀實體XML檔案轉成字串輸出
		JAXBContext context = JAXBContext.newInstance(Book.class);
		Unmarshaller unmar = context.createUnmarshaller();
		InputStream is =  servletContext.getResourceAsStream("/WEB-INF/resource/book.xml");
		Book book = (Book) unmar.unmarshal(is);
		logger.info(book);
		
		return book;
	}
}
