package basic.model;

public class User {

	private String userName;
	
	private String password;
	
	private String ip;
	
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
}
