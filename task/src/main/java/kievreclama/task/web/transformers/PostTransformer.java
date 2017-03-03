package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.Post;
import kievreclama.task.web.models.PostModel;

@Component
public class PostTransformer {

	public Post modelToEntity(PostModel model){
		Post post = new Post();
		post.setId(model.getId());
		post.setName(model.getName());
		post.setHeft(model.getHeft());
		post.setRemove(model.getRemove());
		return post;
	}
	
	public PostModel entityToModel(Post post){
		PostModel postModel = new PostModel();
		postModel.setId(post.getId());
		postModel.setName(post.getName());
		postModel.setHeft(post.getHeft());
		postModel.setRemove(post.getRemove());
		return  postModel;
	}
}
