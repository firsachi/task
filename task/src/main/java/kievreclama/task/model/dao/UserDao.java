package kievreclama.task.model.dao;

import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.entity.User;

@Transactional
public interface UserDao {
	
	@Transactional
	User findByUserName(String username);
}
