package ua.kyiv.informer.ui.user.model;

import jakarta.validation.constraints.Size;

import java.util.Set;

public class UserAddFormModel extends UserModel {

	@Size(min = 8)
	private String repeatPassword;
	
	private Set<Integer> selectedRole;

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	public Set<Integer> getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Set<Integer> selectedRole) {
		this.selectedRole = selectedRole;
	}

	@Override
	public String toString() {
		return "UserAddFormModel [username=" + username + ", password=" + password + ", roles=" + roles + ", enabled=" + enabled +", repeatPassword=" + repeatPassword + ", selectedRoles=" + selectedRole +"]";
	}

	
}
