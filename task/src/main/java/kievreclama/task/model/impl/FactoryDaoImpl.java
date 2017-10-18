package kievreclama.task.model.impl;

import org.springframework.beans.factory.annotation.Autowired;

import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.PhoneDao;
import kievreclama.task.model.dao.UserDao;

public class FactoryDaoImpl extends FactoryDao{
	
	@Autowired
	private PhoneDao phoneDaoImpl;
	
	@Autowired
	private UserDao userDaoImpl;

	@Override
	public UserDao cerateUserDao() {
		return userDaoImpl;
	}

	@Override
	public PhoneDao createPhoneDao() {
		return phoneDaoImpl;
	}
	

}
