/**
 * 
 */
package kievreclama.task.web;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.entity.Role;
import kievreclama.task.entity.User;
import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.UserDao;

/**
 * @author firsov
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private FactoryDao factoryDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(passwordEncoder.encode("tomcat"));
		UserDao repository = factoryDao.cerateUserDao();
		User user = repository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
}

}
