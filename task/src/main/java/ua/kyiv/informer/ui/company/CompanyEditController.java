package ua.kyiv.informer.ui.company;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.kyiv.informer.logic.service.CompanyService;

@Controller
@SessionAttributes(value = "company")
public class CompanyEditController extends CoreCompanuController {

    @Autowired
    public CompanyEditController(@Qualifier("companyService") CompanyService companyService) {
        super(companyService, "company-edit");
    }

    @PreAuthorize("hasAnyAuthority('company:write')")
    @GetMapping(path = {"etdt/{id}/", "/edit/{id}"})
    public String editCompanyPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("company", getCompanyService().byId(id));
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('company:write')")
    @PostMapping(path = {"/edit/{id}", "edit/{id}/"})
    public String submit(@Valid @ModelAttribute("company") CompanyModel companyModel, BindingResult bindingResult, SessionStatus sessionStatus) {
        if (getCompanyService().findQnique(companyModel)) {
            bindingResult.rejectValue("nameCompany", "unique.value.violation");
        }
        if (bindingResult.hasErrors()) {
            return getUrl();
        }
        else {
            getCompanyService().update(companyModel);
            sessionStatus.setComplete();
            return getRedirectUrl();
        }
    }

}
