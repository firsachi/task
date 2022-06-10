package informer.service.user;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.db.UserRepositoryImpl;
import informer.model.UserModel;

@Service
public class UserAppService {
	
	@Autowired
	private UserRepositoryImpl userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public List<UserModel> getListUser(){
		return userRepository.byList("User.allUsers")
				.stream().map(userApp -> modelMapper.map(userApp, UserModel.class))
				.collect(Collectors.toList());
	}

	public boolean findUsername(String username) {
		return userRepository.uniqueUsermane(username);
	}
}
