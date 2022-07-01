package ua.kyiv.ui;

import java.util.List;
import java.util.Set;

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
import informer.repository.RoleRepositiry;
import informer.repository.entity.Role;
import ua.kyiv.logic.UserAppService;
import ua.kyiv.ui.model.UserAddFormModel;

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
	
	@GetMapping(params = {"page"})
	public String userPage(@Param(value = "page") String page, ModelMap model) {
		if (page.toLowerCase().equals(PageAddEdit.ADD.toString().toLowerCase())) {
			model.addAttribute("user", new UserAddFormModel());
			return "users/users";
		}
		return "redirect:/users";
	}
	
	@PostMapping(params = {"page"})
	public String userAddPage(@Valid @ModelAttribute("user") UserAddFormModel userModel, final BindingResult bindingResult) {
		if (!userAppService.findUsername(userModel.getUsername())) {
			bindingResult.rejectValue("username","unique.value.violation");
		}
		if (!userModel.getPassword().equals(userModel.getRepeatPassword())) {
			bindingResult.rejectValue("password","unique.password");
			bindingResult.rejectValue("repeatPassword","unique.password");
		}
		if (bindingResult.hasErrors()) {
			return "users/users";
		}
		userAppService.save(userModel);
		return "redirect:/users";
	}

}
