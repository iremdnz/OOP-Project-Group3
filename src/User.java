
public class User {
	
	private String userName;
	public static String userType = "user" , adminName = "admin" ,adminPassword = "1234";

	public User(String userName) {
		this.userName= userName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
