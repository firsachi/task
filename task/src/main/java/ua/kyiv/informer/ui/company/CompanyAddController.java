package ua.kyiv.informer.ui.company;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.service.CompanyService;

@Controller("companyAddController")
public class CompanyAddController extends CoreCompanuController {

    
    public CompanyAddController(@Qualifier("companyService") CompanyService companyService) {
        super(companyService, "company-add");
    }

    @PreAuthorize("hasAnyAuthority('company:write')")
    @GetMapping(path = {"/add", "add/"})
    public String companyAddPage(Model model) {
        model.addAttribute("company", new CompanyModel());
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('company:write')")
    @PostMapping(path = {"/add", "add/"})
    public String submitButtonFormAddCompany(@Valid @ModelAttribute("company") CompanyModel companyModel, BindingResult bindingResult) {
        companyModel.setId(0);
        if (bindingResult.hasErrors()) {
            return getUrl();
        }
        else {
            getCompanyService().save(companyModel);
            return getRedirectUrl();
        }
    }

}
