
/**
 * 
 */
package ua.kyiv.informer.logic;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import informer.repository.UserRepositoryImpl;
import informer.repository.entity.Role;
import informer.repository.entity.UserApp;


/**
 * @author firsov
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UserRepositoryImpl userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

}
