
public class User {
	
	private String userType,adminPassword;

	public User(String userType, String adminPassword) {
		this.userType = userType;
		this.adminPassword = adminPassword;
	}
	
	public User(String userType) {
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
