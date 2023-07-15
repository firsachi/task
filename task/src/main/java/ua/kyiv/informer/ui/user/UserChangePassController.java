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
import ua.kyiv.informer.ui.user.model.UserChangePassModel;

@Controller
public class UserChangePassController extends UserMainController {

    @Override
    public String getNameFragment() {
        return null;
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @GetMapping(path = {"/pass/{username}'", "/pass/{username}"})
    public String changePass(@PathVariable String username, ModelMap modelMap){
        modelMap.addAttribute("userChangePass", new UserChangePassModel(username));
        return getPatchPage();
    }

    @PreAuthorize("hasAnyAuthority('user:write')")
    @PostMapping(path = {"/pass/{username}'", "/pass/{username}"})
    public String submit(@Valid @ModelAttribute("userChangePass") UserChangePassModel userModel, BindingResult bindingResult){
        validatePass(userModel.getPassword(), userModel.getRepeatPassword(), bindingResult);
        if (bindingResult.hasErrors()) {
            return getPatchPage();
        }
        getUserAppService().changePassword(userModel);
        return "redirect:/users/";
    }

}
