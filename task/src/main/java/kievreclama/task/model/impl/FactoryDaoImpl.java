package kievreclama.task.model.impl;

import org.springframework.beans.factory.annotation.Autowired;

import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.UserDao;

public class FactoryDaoImpl extends FactoryDao{
	
	@Autowired
	private UserDao userDaoImpl;

	@Override
	public UserDao cerateUserDao() {
		return userDaoImpl;
	}

}
