package kievreclama.task.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import kievreclama.task.dao.MainDao;
import kievreclama.task.entity.Post;

@Repository("postDao")
public class PostDaoImpl extends MainDao<Post>{

	@Override
	public Post byId(int id) {
		return em.find(Post.class, id);
	}

	@Override
	public List<Post> byList(String namedQery) {;
		TypedQuery<Post> postList = em.createNamedQuery(namedQery, Post.class);
		return postList.getResultList();
	}

}
