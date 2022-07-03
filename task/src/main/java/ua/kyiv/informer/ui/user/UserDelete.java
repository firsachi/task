package ua.kyiv.informer.ui.user;

public class UserDelete {

	private String username;

	public UserDelete() {
	}
	
	public UserDelete(String username) {
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
