package basic.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 加XmlRootElement、XmlElement是要實作接收、回傳XML格式，
 * 程式在XmlRequestController
 * 
 * @author coreyou
 *
 */
@XmlRootElement
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private String author;
	
	public Book() {
		super();
	}
	
	public Book(Integer id, String name, String author) {
		super();
		this.setId(id);
		this.setName(name);
		this.setAuthor(author);
	}

	public Integer getId() {
		return id;
	}

	@XmlElement
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}
