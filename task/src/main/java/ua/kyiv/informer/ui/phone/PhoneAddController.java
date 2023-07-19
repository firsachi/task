package ua.kyiv.informer.ui.phone;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.service.PhoneService;

@Controller
public class PhoneAddController extends CorePhoneController{

    @Autowired
    public PhoneAddController(@Qualifier("phoneService") PhoneService phoneService) {
        super(phoneService, "phone-add");
    }

    @PreAuthorize("hasAnyAuthority('phone:write')")
    @GetMapping(path = {"/add", "add/"})
    public String phoneAddPage(Model model) {
        model.addAttribute("phone", new PhoneModel());
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('phone:write')")
    @PostMapping(path = {"add/", "/add"})
    public String submitAddPage(@Valid @ModelAttribute("phone") PhoneModel phoneModel, BindingResult bindingResult) {
        phoneModel.setId(0);
        if (getPhoneService().checkUniqueNumberPhone(phoneModel.getNumberPhone())) {
            bindingResult.rejectValue("numberPhone", "unique.value.violation");
        }
        if (bindingResult.hasErrors()){
            return getUrl();
        }
        else {
            getPhoneService().add(phoneModel);
            return getRedirect();
        }
    }

}
