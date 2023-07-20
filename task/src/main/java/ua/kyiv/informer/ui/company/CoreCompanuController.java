package ua.kyiv.informer.ui.company;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kyiv.informer.logic.service.CompanyService;

@RequestMapping(path = {"company/", "/company"})
public abstract class CoreCompanuController {

    private final CompanyService companyService;

    private final String nameFragment;

    public CoreCompanuController(CompanyService companyService, String nameFragment) {
        this.companyService = companyService;
        this.nameFragment = nameFragment;
    }

    @ModelAttribute("nameFragment")
    public  String getNameFragment() {
        return this.nameFragment;
    }

    public  CompanyService getCompanyService() {
        return  this.companyService;
    }

    protected String getUrl() {
        return  "company/company";
    }

    protected String getRedirectUrl() {
        return  "redirect:/company/";
    }
}
