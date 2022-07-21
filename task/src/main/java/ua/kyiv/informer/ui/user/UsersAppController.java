package ua.kyiv.informer.ui.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.UserAppService;
import ua.kyiv.informer.repository.RoleRepositiry;
import ua.kyiv.informer.repository.entity.Role;

@Controller
@RequestMapping(path = {"/users", "/users/"})
public class UsersAppController {
	
	private final String REDIRECT_URL = "redirect:/users/";
	
	@Autowired
	private RoleRepositiry roleRepository;
	
	@Autowired
	private UserAppService userAppService;
	
	@ModelAttribute("roles")
	public List<Role> getRoleList() {
		return roleRepository.byList("Role.All");
	}
	
	@GetMapping
	public String usersPage(ModelMap model) {
		model.addAttribute("userList", userAppService.getListUser());
		model.addAttribute("page", "");
		return "users/users";
	}
	
	@GetMapping(path = {"/add", "/add/"})
	public String userPage(ModelMap model) {
		model.addAttribute("user", new UserAddFormModel());
		model.addAttribute("page", "add");
		return "users/users";
	}
	
	@PostMapping(path = {"/add", "/add/"})
	public String userAddPage(@Valid @ModelAttribute("user") UserAddFormModel userModel, BindingResult bindingResult, ModelMap model) {
		if (!userAppService.findUsername(userModel.getUsername())) {
			bindingResult.rejectValue("username","unique.value.violation");
		}
		validatePass(userModel.getPassword(), userModel.getRepeatPassword(), bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("page", "add");
			return "users/users";
		}
		userAppService.save(userModel);
		return REDIRECT_URL;
	}
	
	@GetMapping(path = {"/pass", "/pass/"}, params = {"username"})
	public String pass(@Param(value = "username") String username, ModelMap model) {
		model.addAttribute("userChangePass", new UserChangePass(username));
		model.addAttribute("page", "pass");
		return "users/users";
	}
	
	@PostMapping(path = {"/pass", "/pass/"})
	public String pass(@Valid @ModelAttribute("userChangePass") UserChangePass userModel, BindingResult bindingResult, ModelMap model) {
		validatePass(userModel.getPassword(), userModel.getRepeatPassword(), bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("page", "pass");
			return "users/users";
		}
		userAppService.changePassword(userModel);
		return REDIRECT_URL;
	}
	
	@GetMapping( path = {"/del", "/del/"}, params = {"username"})
	public String delete(@Param("username") String username,  ModelMap model) {
		model.addAttribute("userdel", new UserDelete(username));
		model.addAttribute("page", "del");
		return "users/users";
	}
	
	@PostMapping(path = {"/del", "/del/"})
	public String delete(@ModelAttribute("userdel") UserDelete model) {
		userAppService.delete(model.getUsername());
		return REDIRECT_URL;
	}
	
	@GetMapping(path = {"/edit", "/edit/"}, params = {"username"})
	public String editPage(@Param("username") String username,  ModelMap model) {
		model.addAttribute("user", userAppService.byUserApp(new UserEditModel(username)));
		model.addAttribute("page", "edit");
		return "users/users";
	}
	
	@PostMapping(path = {"/edit", "/edit/"}, params = {"username"})
	public String editPage(@Valid @ModelAttribute("user") UserEditModel userModel, BindingResult bindingResult, ModelMap model) {
		userAppService.update(userModel);
		return REDIRECT_URL;
	}
	
	private void validatePass(String password, String repeatPassword, BindingResult bindingResult) {
		if (!password.equals(repeatPassword)) {
			bindingResult.rejectValue("password","unique.password");
			bindingResult.rejectValue("repeatPassword","unique.password");
		}
	}
}
