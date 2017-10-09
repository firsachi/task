package kievreclama.task.model.impl;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kievreclama.task.entity.User;
import kievreclama.task.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		String query = "SELECT u FROM User u WHERE u.username = :username";
		TypedQuery<User> typedQuery = session.createQuery(query, User.class);
		typedQuery.setParameter("username", username);
		return typedQuery.getSingleResult();
	}

}
