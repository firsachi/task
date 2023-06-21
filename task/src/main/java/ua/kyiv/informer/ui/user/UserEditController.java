package ua.kyiv.informer.ui.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.entity.Role;
import ua.kyiv.informer.logic.repository.RoleRepositiry;
import ua.kyiv.informer.ui.CoreController;
import ua.kyiv.informer.ui.user.model.UserEditModel;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserEditController extends UserMainController implements CoreController {

    @Autowired
    private RoleRepositiry roleRepositiry;

    @Override
    public String getNameFragment() {
        return "edit-user";
    }

    @ModelAttribute("roles")
    public List<Role> getRoleList() {
        return roleRepositiry.byList("Role.All");
    }

    @GetMapping(path = {"/edit/{username}", "/edit/{username}/"})
    public String editPage(@PathVariable String username, ModelMap modelMap) {
        modelMap.addAttribute("user", getUserAppService().byUserEditApp(username));
        return getPachPage();
    }
    @PostMapping(path = {"/edit/{username}", "/edit/{username}/}"})
    public String submit(@Valid @ModelAttribute("user") UserEditModel userModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getPachPage();
        }
        getUserAppService().update(userModel);
        return "redirect:/users/";
    }

}