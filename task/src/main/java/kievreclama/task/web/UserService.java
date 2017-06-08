package kievreclama.task.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.dao.UserDao;
import kievreclama.task.entity.User;
import kievreclama.task.entity.UserRole;
import kievreclama.task.web.transformers.UserTransformer;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDao userDaoImpl;
	
	@Autowired
	private UserTransformer userTransformer;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = userDaoImpl.findByUserName(username);
		if(user == null) throw new UsernameNotFoundException("Not faud user.");
		System.out.println(user.getUsername());
		return userTransformer.entityToModel(user);
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
