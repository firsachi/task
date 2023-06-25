package ua.kyiv.informer.ui.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersAppController extends UserMainController {

	@GetMapping
	public String usersPage(ModelMap model) {
		model.addAttribute("nameFragment", "user-table");
		model.addAttribute("userList", getUserAppService().getListUser());
		return "user/app-user";
	}

}
