package ua.kyiv.informer.logic;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import informer.repository.RoleRepositiry;
import informer.repository.UserRepositoryImpl;
import informer.repository.entity.UserApp;
import ua.kyiv.informer.ui.model.UserAddFormModel;
import ua.kyiv.informer.ui.model.UserModel;

@Service
public class UserAppService {
	
	@Autowired
	private UserRepositoryImpl userRepository;
	
	@Autowired
	private RoleRepositiry roleRepositiry;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional
	public List<UserModel> getListUser(){
		return userRepository.byList("User.allUsers")
				.stream().map(userApp -> modelMapper.map(userApp, UserModel.class))
				.collect(Collectors.toList());
	}

	public boolean findUsername(String username) {
		return userRepository.uniqueUsermane(username);
	}
	
	@Transactional
	public UserModel byUserApp(String username) {
		return modelMapper.map(userRepository.byId(username), UserModel.class);
	}

	@Transactional
	public void save(UserAddFormModel userModel) {
		UserApp userApp = modelMapper.map(userModel, UserApp.class);
		userApp.setRoles(userModel.getSelectedRole().stream().map(roleId -> roleRepositiry.byId(roleId)).collect(Collectors.toSet()));
		userApp.setPassword(passwordEncoder.encode(userApp.getPassword()));
		userRepository.insert(userApp);
	}
	
	@Transactional
	public void delete(String username) {
		userRepository.delete(userRepository.byId(username));
	}
}
