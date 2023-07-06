package ua.kyiv.informer.ui.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kyiv.informer.logic.service.UserAppService;

@RequestMapping(path = {"/users", "users/"})
public abstract class UserMainController {

    @Autowired
    private UserAppService userAppService;

    @ModelAttribute("nameFragment")
    public abstract String getNameFragment();

    public UserAppService getUserAppService(){
        return  userAppService;
    }

    public String getPatchPage() {
        return "user/app-user";
    }

    protected void validatePass(String password, String repeatPassword, BindingResult bindingResult) {
        if (!password.equals(repeatPassword)) {
            bindingResult.rejectValue("password","unique.password");
            bindingResult.rejectValue("repeatPassword","unique.password");
        }
    }

}
