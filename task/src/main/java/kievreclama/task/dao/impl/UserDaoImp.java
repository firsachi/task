package kievreclama.task.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kievreclama.task.dao.UserDao;
import kievreclama.task.entity.User;

@Repository
public class UserDaoImp implements UserDao{
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SLECT u FROM User u WHERE u.username = :username";
		TypedQuery<User> typedQuery = session.createQuery(query, User.class);
		typedQuery.setParameter(query, username);
		List<User> users = typedQuery.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
