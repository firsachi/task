package ua.kyiv.informer.ui.phone;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kyiv.informer.logic.service.PhoneService;

@Controller("phoneController")
public class PhoneController  extends CorePhoneController {

    public PhoneController(@Qualifier("phoneService") PhoneService phoneService) {
        super(phoneService, "phone-table");
    }

    @RequestMapping
    @PreAuthorize("hasAnyAuthority('phone:read')")
    public String phonePage(Model model) {
        model.addAttribute("phones", getPhoneService().getAll("allPhone"));
        return getUrl();
    }

}
