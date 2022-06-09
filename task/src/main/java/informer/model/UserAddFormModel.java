package informer.model;

import javax.validation.constraints.NotBlank;

public class UserAddFormModel extends UserModel {

	private static final long serialVersionUID = 2196966617106815840L;

	@NotBlank
	private String repeatPassword;

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	@Override
	public String toString() {
		return "UserAddFormModel [username=" + username + ", password=" + password + ", roles=" + roles + ", enabled=" + enabled +", repeatPassword=" + repeatPassword + "]";
	}

	
}
