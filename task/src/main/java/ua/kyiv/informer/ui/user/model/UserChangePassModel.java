package ua.kyiv.informer.ui.user.model;

import java.util.Objects;

import javax.validation.constraints.Size;

public class UserChangePassModel {
	
	private String username;
	
	@Size(min = 8)
	private String password;
	
	@Size(min = 8)
	private String repeatPassword;

	public UserChangePassModel() {
		super();
	}
	
	public UserChangePassModel(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, repeatPassword, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserChangePassModel other = (UserChangePassModel) obj;
		return Objects.equals(password, other.password) && Objects.equals(repeatPassword, other.repeatPassword)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserChangePass [username=" + username + ", password=" + password + ", repeatPassword=" + repeatPassword
				+ "]";
	}
	
}
