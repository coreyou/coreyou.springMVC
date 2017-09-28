package basic.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String password;
	
	private String ip;
	
	private Date birthday;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String password, String ip) {
		setUserName(userName);
		setPassword(password);
		setIp(ip);
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String name) {
		this.userName = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
