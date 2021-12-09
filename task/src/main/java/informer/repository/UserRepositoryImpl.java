/**
 * 
 */
package informer.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import informer.entity.User;

/**
 * @author firsov
 *
 */
@Repository("userDao")
public class UserRepositoryImpl extends MainDao<User>{

	@Override
	public User byId(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> byList(String namedQery) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByUserName(String username) {
		TypedQuery<User> query = em.createNamedQuery("User.findUsername", User.class);
		query.setParameter("username", username);
		User user = query.getSingleResult();
		return user;
	}

}
