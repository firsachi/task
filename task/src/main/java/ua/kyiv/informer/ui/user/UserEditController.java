package ua.kyiv.informer.ui.user;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.entity.Role;
import ua.kyiv.informer.logic.repository.RoleRepositiry;
import ua.kyiv.informer.ui.user.model.UserChangeModel;


import java.util.List;

@Controller
public class UserEditController extends UserMainController {

    private final RoleRepositiry roleRepositiry;

    public UserEditController(RoleRepositiry roleRepositiry) {
        this.roleRepositiry = roleRepositiry;
    }

    @Override
    public String getNameFragment() {
        return "edit-user";
    }

    @ModelAttribute("roles")
    public List<Role> getRoleList() {
        return roleRepositiry.byList("Role.All");
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @GetMapping(path = {"/edit/{username}", "/edit/{username}/"})
    public String editPage(@PathVariable String username, ModelMap modelMap) {
        modelMap.addAttribute("userEdit", getUserAppService().byUserEditApp(username));
        return getPatchPage();
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @PostMapping(path = {"edit/{username}", "/edit/{username}/"})
    public String submitPage(@Valid @ModelAttribute("userEdit")UserChangeModel userChangeModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
           return getPatchPage();
        }
        else {
            getUserAppService().update(userChangeModel);
            return "redirect:/users/";
        }
    }

}
