package ua.kyiv.informer.ui.user.model;

import java.util.Objects;
import java.util.Set;

public class UserEditModel {
	
	private String username;
	
	private Set<Integer> selectedRole;
	
	private boolean enabled;
	
	public UserEditModel() {
	}

	public UserEditModel(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Integer> getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Set<Integer> selectedRole) {
		this.selectedRole = selectedRole;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enabled, selectedRole, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEditModel other = (UserEditModel) obj;
		return enabled == other.enabled && Objects.equals(selectedRole, other.selectedRole)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserEditModel [username=" + username + ", selectedRole=" + selectedRole + ", enabled=" + enabled + "]";
	}
	
}
