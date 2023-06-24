package ua.kyiv.informer.ui.user.model;

public class UserDeleteModel {

	private String username;

	public UserDeleteModel() {
	}
	
	public UserDeleteModel(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserDelete [username=" + username + "]";
	}
	
}
