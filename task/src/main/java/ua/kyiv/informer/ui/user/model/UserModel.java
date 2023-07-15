package ua.kyiv.informer.ui.user.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ua.kyiv.informer.logic.entity.Role;

public class UserModel{
	
	/**
	 * serial version 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	protected String username;
	
	@Size(min = 8)
	protected String password;
	
	protected Set<Role> roles;
	
	protected boolean enabled;

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
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserModel [username=" + username + ", password=" + password + ", roles=" + roles + ", enabled="
				+ enabled + "]";
	}
	
}
