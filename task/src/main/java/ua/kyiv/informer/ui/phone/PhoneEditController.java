package ua.kyiv.informer.ui.phone;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.kyiv.informer.logic.service.PhoneService;

@Controller
@SessionAttributes(value = "phone")
public class PhoneEditController extends CorePhoneController {

    public PhoneEditController(@Qualifier("phoneService") PhoneService phoneService) {
        super(phoneService, "phone-edit");
    }

    @PreAuthorize("hasAnyAuthority('phone:write')")
    @GetMapping(path = {"/edit/{id}", "edit/{id}/"})
    public String pageEditPhone(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", getPhoneService().byId(id));
        return getUrl();
    }

    @PostMapping(path = {"/edit/{id}", "edit/{id}/"})
    @PreAuthorize("hasAnyAuthority('phone:write')")
    public String submitEditPhone(@Valid @ModelAttribute("phone") PhoneModel phoneModel, BindingResult bindingResult, SessionStatus sessionStatus){
        if (getPhoneService().checkUniqueNumberPhone(phoneModel.getNumberPhone())) {
            bindingResult.rejectValue("numberPhone", "unique.value.violation");
        }
        if (bindingResult.hasErrors()){
            return getUrl();
        }
        else {
            sessionStatus.setComplete();
            getPhoneService().update(phoneModel);
            return getRedirect();
        }
    }
}
