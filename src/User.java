
public class User {
	
	private static String userName;
	public static String userType = "user" , adminName = "admin" ,adminPassword = "1234";
	
	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		User.userName = userName;
	}
	
}
