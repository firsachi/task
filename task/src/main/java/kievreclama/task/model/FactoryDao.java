package kievreclama.task.model;

import kievreclama.task.model.dao.UserDao;

public abstract class FactoryDao {
	
	public abstract UserDao cerateUserDao();
	
	public static FactoryDao getInstance() {
		try {
			Class<?> classInstanse = Class.forName("kievreclama.task.model.impl.FactoryDaoImpl");
			return (FactoryDao) classInstanse.newInstance();
		}catch (Exception e) {
			 return null;
		}
	}
}
