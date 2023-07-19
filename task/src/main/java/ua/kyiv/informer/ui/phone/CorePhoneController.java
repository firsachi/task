package ua.kyiv.informer.ui.phone;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kyiv.informer.logic.service.PhoneService;

@RequestMapping(path = {"/phone", "phone/"})
public abstract class CorePhoneController{

    private final PhoneService phoneService;

    private String nameFragment;

    public CorePhoneController(PhoneService phoneService, String nameFragment) {
        this.phoneService = phoneService;
        this.nameFragment = nameFragment;
    }

    public PhoneService getPhoneService(){
        return  this.phoneService;
    }

    @ModelAttribute("nameFragment")
    public String getNameFragment() {
        return nameFragment;
    }
    protected String getUrl() {
        return  "phone/phone";
    }

    protected String getRedirect() {
        return "redirect:/phone/";
    }
}
