package informer.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.service.user.UserAppService;

@Controller
@RequestMapping(path = {"/users", "/users/"})
public class UsersAppController {
	
	@Autowired
	private UserAppService userAppService;
	
	@GetMapping
	public String usersPage(ModelMap model) {
		model.addAttribute("userList", userAppService.getListUser());
		return "users/users";
	}
	
	@GetMapping(params = "add")
	public String usersAdd() {
		return "users/users";
	}

}
