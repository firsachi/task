package ua.kyiv.informer.ui.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.ui.CoreController;
import ua.kyiv.informer.ui.user.model.UserChangePassModel;

import javax.validation.Valid;

@Controller
public class UserChangePassController extends UserMainController implements CoreController {

    @Override
    public String getNameFragment() {
        return "change-pass-user";
    }

    @GetMapping(path = {"/pass/{username}'", "/pass/{username}"})
    public String changePass(@PathVariable String username, ModelMap modelMap){
        modelMap.addAttribute("userChangePass", new UserChangePassModel(username));
        return getPachPage();
    }
    @PostMapping(path = {"/pass/{username}'", "/pass/{username}"})
    public String submit(@Valid @ModelAttribute("userChangePass") UserChangePassModel userModel, BindingResult bindingResult, ModelMap model){
        validatePass(userModel.getPassword(), userModel.getRepeatPassword(), bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("page", "add");
            return getPachPage();
        }
        getUserAppService().changePassword(userModel);
        return "redirect:/users/";
    }
}
