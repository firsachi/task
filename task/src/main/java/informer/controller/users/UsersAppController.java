package informer.controller.users;

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
import informer.model.UserAddFormModel;
import informer.model.UserModel;
import informer.service.user.UserAppService;

@Controller
@RequestMapping(path = {"/users", "/users/"})
public class UsersAppController {
	
	@Autowired
	private UserAppService userAppService;
	
	@GetMapping
	public String usersPage( ModelMap model) {
		model.addAttribute("userList", userAppService.getListUser());
		return "users/users";
	}
	
	@GetMapping(params = {"page"})
	public String userPage(@Param(value = "page") String page, ModelMap model) {
		model.addAttribute("user", new UserAddFormModel());
		if (page.toLowerCase().equals(PageAddEdit.ADD.toString().toLowerCase())) {
			return "users/users";
		}
		return "redirect:/users";
	}
	
	@PostMapping(params = {"page"})
	public String userAddPage(@Valid @ModelAttribute("user") UserAddFormModel userModel, final BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "users/users";
		}
		return "redirect:/users";
	}

}
