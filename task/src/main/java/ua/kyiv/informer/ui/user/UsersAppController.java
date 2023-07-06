package ua.kyiv.informer.ui.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersAppController extends UserMainController {

	@Override
	public String getNameFragment() {
		return "user-table";
	}

	@GetMapping
	@PreAuthorize("hasAnyAuthority('user:read')")
	public String usersPage(ModelMap modelMap) {
		modelMap.addAttribute("userList", getUserAppService().getListUser());
		return getPatchPage();
	}
}
