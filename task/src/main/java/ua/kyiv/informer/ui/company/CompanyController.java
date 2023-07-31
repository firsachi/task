package ua.kyiv.informer.ui.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PreAuthorize("hasAnyAuthority('employee:write')")
	@PostMapping(path = {"datalist/", "/datalist"})
	public String datalistDepartmentsCompany(@ModelAttribute("companyId")int companyId, Model model){
		model.addAttribute("departments", getCompanyService().getCompanyDepartments(companyId));
		return "company/company-fragment :: datalist-department";
	}
}
