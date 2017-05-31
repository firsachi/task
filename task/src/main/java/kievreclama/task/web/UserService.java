package kievreclama.task.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.UserDao;
import kievreclama.task.entity.User;
import kievreclama.task.entity.UserRole;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDao userDaoImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDaoImpl.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<GrantedAuthority> buildUserAuthority(UserRole userRole) {
		// TODO Auto-generated method stub
		return null;
	}

}
