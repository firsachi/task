package ua.kyiv.informer.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import ua.kyiv.informer.logic.entity.UserApp;

/**
 * @author firsov
 *
 */

public class UserDetailsServiceImp implements UserDetailsService {

	private final UserRepo userRepo;
	public UserDetailsServiceImp( UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp user = userRepo.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		return new UserAppDetails(user);
	}
}
