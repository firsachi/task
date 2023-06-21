package ua.kyiv.informer.ui.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import ua.kyiv.informer.logic.service.UserAppService;

@Controller
//@RequestMapping(path = {"/users", "users/"})
public class UsersAppController extends UserMainController {

	@GetMapping
	public String usersPage(ModelMap model) {
		model.addAttribute("nameFragment", "user-table");
		model.addAttribute("userList", getUserAppService().getListUser());
		return "user/app-user";
	}
	/*

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

	 */
}
