package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.User;
import kievreclama.task.web.models.UserModel;

@Component("userTransformer")
public class UserTransformer implements BaseTransformer<User, UserModel>{

	@Override
	public User modelToEntity(UserModel model) {
		User user = new User();
		user.setUsername(model.getUsername());
		user.setPassword(model.getPassword());
		user.setEnabled(model.isEnabled());
		return user;
	}

	@Override
	public UserModel entityToModel(User entity) {
		UserModel model = new UserModel();
		model.setUsername(entity.getUsername());
		model.setPassword(entity.getPassword());
		model.setEnabled(entity.isEnabled());
		return model;
	}

}
