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

import informer.controller.PageAddEdit;
import ua.kyiv.informer.logic.UserAppService;
import ua.kyiv.informer.repository.RoleRepositiry;
import ua.kyiv.informer.repository.entity.Role;

@Controller
@RequestMapping(path = {"/users", "/users/"})
public class UsersAppController {
	@Autowired
	private RoleRepositiry roleRepository;
	
	@Autowired
	private UserAppService userAppService;
	
	@ModelAttribute("roles")
	public List<Role> getRoleList() {
		return roleRepository.byList("Role.All");
	}
	
	@GetMapping
	public String usersPage( ModelMap model) {
		model.addAttribute("userList", userAppService.getListUser());
		return "users/users";
	}
	
	@GetMapping(params = {"add"})
	public String userPage( ModelMap model) {
		System.out.println(1);

			model.addAttribute("user", new UserAddFormModel());
			return "users/users";

	}
	/*
	@GetMapping(params = {"page", "username"})
	public String router(@Param(value = "page") String page, @Param(value = "username") String username, ModelMap model) {
		String changePass = "pass";
		System.out.println(2);
		if (page.toLowerCase().equals(PageAddEdit.DELETE.label)) {
			model.addAttribute("user", new UserDelete(username));
			return "users/users";
		} else if(page.toLowerCase().equals(PageAddEdit.EDIT.label)) {
			
			return "users/users";
		} else if (page.toLowerCase().equals(changePass)) {
			model.addAttribute("userChangePass", new UserChangePass(username));
			return "users/users";
		}
		return redirectPageUsers();
	}
	*/
	@PostMapping(params = {"add"})
	public String userAddPage(@Param(value = "add") String page, @Valid @ModelAttribute("user") UserAddFormModel userModel, final BindingResult bindingResult) {
		if (!userAppService.findUsername(userModel.getUsername())) {
			bindingResult.rejectValue("username","unique.value.violation");
		}
		//validatePass(userModel.getPassword(), userModel.getRepeatPassword(), bindingResult);
		if (bindingResult.hasErrors()) {
			return "users/users";
		}
		userAppService.save(userModel);
		return "redirect:/users";
	}
	/*
	@PostMapping(params = {"page", "username"})
	private String changePassword(@Valid @ModelAttribute("userChangePass") UserChangePass model, final BindingResult bindingResult) {
		validatePass(model.getPassword(), model.getRepeatPassword(), bindingResult);
		if (bindingResult.hasErrors()) {
			return "users/users";
		}
		userAppService.changePassword(model);
		return redirectPageUsers();
	}
	/*
	@PostMapping(params = {"page", "username"})
	public String pageDelete(@ModelAttribute("userDelete") UserDelete model) {
		userAppService.delete(model.getUsername());
		return redirectPageUsers();
	}
	*/
	private void validatePass(String password, String repeatPassword, BindingResult bindingResult) {
		if (!password.equals(repeatPassword)) {
			bindingResult.rejectValue("password","unique.password");
			bindingResult.rejectValue("repeatPassword","unique.password");
		}
	}

	private String redirectPageUsers() {
		return "redirect:/users";
	}

}
