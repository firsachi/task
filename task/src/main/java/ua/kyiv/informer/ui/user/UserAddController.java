package ua.kyiv.informer.ui.user;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.entity.Role;
import ua.kyiv.informer.logic.repository.RoleRepositiry;
import ua.kyiv.informer.ui.user.model.UserAddFormModel;

import java.util.List;

@Controller
public class UserAddController extends UserMainController {

    private final RoleRepositiry roleRepository;

    public UserAddController(RoleRepositiry roleRepository) {
        this.roleRepository = roleRepository;
    }

    @ModelAttribute("roles")
    public List<Role> getRoleList() {
        return roleRepository.byList("Role.All");
    }

    @Override
    public String getNameFragment() {
        return "add-user";
    }

    @GetMapping(path = {"/add", "add/"})
    @PreAuthorize("hasAnyAuthority('user:write')")
    public String addPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new UserAddFormModel());
        return getPatchPage();
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @PostMapping(path = {"/add", "/add/"})
    public String userAddPage(@Valid @ModelAttribute("user") UserAddFormModel userModel, BindingResult bindingResult, ModelMap model) {
        if (!getUserAppService().findUsername(userModel.getUsername())) {
            bindingResult.rejectValue("username","unique.value.violation");
        }
        validatePass(userModel.getPassword(), userModel.getRepeatPassword(), bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("page", "add");
            return getPatchPage();
        }
        getUserAppService().save(userModel);
        return "redirect:/users/";
    }
}
