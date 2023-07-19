package ua.kyiv.informer.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kyiv.informer.logic.entity.Role;
import ua.kyiv.informer.logic.entity.UserApp;
import ua.kyiv.informer.logic.repository.UserRepositoryImpl;

/**
 * @author firsov
 *
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImp implements UserDetailsService {

	private final UserRepositoryImpl userDao;

	public UserDetailsServiceImp(UserRepositoryImpl userDao) {
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		return new UserAppDetails(user);
	}
}
