package ua.kyiv.informer.ui.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.entity.Role;
import ua.kyiv.informer.logic.repository.RoleRepositiry;
import ua.kyiv.informer.ui.CoreController;
import ua.kyiv.informer.ui.user.model.UserAddFormModel;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController extends UserMainController implements CoreController {

    @Autowired
    private RoleRepositiry roleRepository;

    @ModelAttribute("roles")
    public List<Role> getRoleList() {
        return roleRepository.byList("Role.All");
    }

    @Override
    public String getNameFragment() {
        return "add-user";
    }
    @GetMapping(path = {"/add", "add/"})
    public String addPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new UserAddFormModel());
        return getPachPage();
    }
    @Secured("ADMINISTRATOR")
    @PostMapping(path = {"/add", "/add/"})
    public String userAddPage(@Valid @ModelAttribute("user") UserAddFormModel userModel, BindingResult bindingResult, ModelMap model) {
        if (!getUserAppService().findUsername(userModel.getUsername())) {
            bindingResult.rejectValue("username","unique.value.violation");
        }
        validatePass(userModel.getPassword(), userModel.getRepeatPassword(), bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("page", "add");
            return getPachPage();
        }
        getUserAppService().save(userModel);
        return "redirect:/users/";
    }

}