package ua.kyiv.informer.ui.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.kyiv.informer.logic.service.CompanyService;

@Controller
public class CompanyController extends CoreCompanuController {

	@Autowired
	public CompanyController(@Qualifier("companyService") CompanyService companyService) {
		super(companyService, "company-table");
	}

	@PreAuthorize("hasAnyAuthority('company:read')")
	@GetMapping
	public String showCompany(Model model) {
		model.addAttribute("companies", getCompanyService().all("allCompany"));
		return getUrl();
	}

}
