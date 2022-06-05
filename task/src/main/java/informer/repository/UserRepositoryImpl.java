/**
 * 
 */
package informer.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import informer.entity.UserApp;

/**
 * @author firsov
 *
 */
@Repository("userDao")
public class UserRepositoryImpl extends MainDao<UserApp>{

	@Override
	public UserApp byId(int id) {
		return em.find(UserApp.class, id);
	}

	@Override
	public List<UserApp> byList(String namedQery) {
		return em.createNamedQuery(namedQery, UserApp.class).getResultList();
	}

	public UserApp findByUserName(String username) {
		TypedQuery<UserApp> query = em.createNamedQuery("User.findUsername", UserApp.class);
		query.setParameter("username", username);
		UserApp user = query.getSingleResult();
		return user;
	}

}
