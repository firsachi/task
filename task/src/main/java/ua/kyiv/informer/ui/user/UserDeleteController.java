package ua.kyiv.informer.ui.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.ui.user.model.UserDeleteModel;

@Controller
public class UserDeleteController extends UserMainController {

    @Override
    public String getNameFragment() {
        return "del-user";
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @GetMapping(path = {"/del/{username}", "del/{username}/"})
    public String deleteUserPage(@PathVariable("username") String username, ModelMap modelMap){
        modelMap.addAttribute("userDelete", new UserDeleteModel(username));
        return getPatchPage();
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @PostMapping(path = {"/del/{username}", "del/{username}"})
    public String submitPage(@ModelAttribute("userDelete")UserDeleteModel userDeleteModel) {
        getUserAppService().delete(userDeleteModel.getUsername());
        return "redirect:/users/";
    }

}
