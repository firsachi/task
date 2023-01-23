package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.logic.entity.UserApp;
import ua.kyiv.informer.logic.repository.RoleRepositiry;
import ua.kyiv.informer.logic.repository.UserRepositoryImpl;
import ua.kyiv.informer.ui.user.UserAddFormModel;
import ua.kyiv.informer.ui.user.UserChangePass;
import ua.kyiv.informer.ui.user.UserEditModel;
import ua.kyiv.informer.ui.user.UserModel;

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
	
	public UserEditModel byUserApp(UserEditModel userEditModel) {
		UserModel userModel = byUserApp(userEditModel.getUsername());
		userEditModel.setSelectedRole(userModel.getRoles().stream().map(role -> role.getRoleId()).collect(Collectors.toSet()));
		userEditModel.setEnabled(userModel.isEnabled());
		return userEditModel;
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
	
	@Transactional
	public void changePassword(UserChangePass model) {
		UserApp user = userRepository.byId(model.getUsername());
		user.setPassword(passwordEncoder.encode(model.getPassword()));
		userRepository.update(user);
	}

	@Transactional
	public void update(UserEditModel userModel) {
		UserApp userApp = modelMapper.map(userModel, UserApp.class);
		userApp.setPassword(userRepository.findByUserName(userApp.getUsername()).getPassword());
		userApp.setRoles(userModel.getSelectedRole().stream().map(roleId -> roleRepositiry.byId(roleId)).collect(Collectors.toSet()));
		userRepository.update(userApp);
	}
}
