package kievreclama.task.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.entity.Post;
import kievreclama.task.web.models.PostModel;
import kievreclama.task.web.transformers.PostTransformer;

@Component
public class PostService extends ServiseTask<PostModel>{
	
	@Autowired
	private PostDaoImpl postDao;
	
	@Autowired 
	private PostTransformer postTransformer;

	@Override
	public void save(PostModel value) {
		postDao.insert(postTransformer.modelToEntity(value));
	}

	@Override
	public void update(PostModel value) {
		postDao.update(postTransformer.modelToEntity(value));
	}

	@Override
	public void delete(int id) {
		postDao.delete(id);
	}

	@Override
	public PostModel getId(int id) {
		return postTransformer.entityToModel(postDao.byId(id));
	}

	@Override
	public List<PostModel> getList(String namedQery) {
		List<PostModel> listPost = new ArrayList<PostModel>();
		for (Post entity: postDao.byList(namedQery)){
			listPost.add(postTransformer.entityToModel(entity));
		}
		return listPost;
	}

}
