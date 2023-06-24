package ua.kyiv.informer.ui.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.kyiv.informer.ui.CoreController;
import ua.kyiv.informer.ui.user.model.UserDeleteModel;
@Controller
public class UserDeleteController extends UserMainController implements CoreController {
    @Override
    public String getNameFragment() {
        return "del-user";
    }
    @GetMapping(path = {"/del/{username}", "del/{username}/"})
    public String deleteUserPage(@PathVariable("username") String username, ModelMap modelMap){
        modelMap.addAttribute("user", new UserDeleteModel(username));
        return getPachPage();
    }
}
