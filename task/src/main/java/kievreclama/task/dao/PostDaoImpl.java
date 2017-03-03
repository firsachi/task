package kievreclama.task.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import kievreclama.task.entity.Post;

@Repository("postDao")
public class PostDaoImpl extends MainDao<Post>{

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createNamedQuery("deletePost").setParameter("id", id).executeUpdate();
	}

	@Override
	public Post byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Post.class, id);
	}

	@Override
	public List<Post> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Post> postList = session.createNamedQuery(namedQery, Post.class);
		return postList.getResultList();
	}

}
