package kievreclama.task.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.UserDao;

@Service
public class InformerUserService implements UserDetailsService{
	
	@Autowired
	private FactoryDao factoryDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao userDao = factoryDao.cerateUserDao();
		return userDao.findByUserName(username);
	}

}
