package kievreclama.task.dao;

import kievreclama.task.entity.User;

public interface UserDao {
	
	User findByUserName(String username);
}
