package informer.controller.company;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import informer.model.CompanyModel;
import informer.service.CompanyService;
import informer.service.CompanyServiceImpl;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@ModelAttribute("companies")
	public List<CompanyModel> allCompany() {
		return companyService.all("allCompany");
	}		
	
	@GetMapping(path = {"company/", "/company"})
	public String showCompany() {
		return "company/company";
	}
	
	@GetMapping(path = {"company/add", "/company/add/"})
	public String pageCompanyAdd(ModelMap model) {
		model.addAttribute("company", new CompanyModel());
		return "company/company-add";
	}
	
	@PostMapping(path = {"company/add", "/company/add/"},  params = {"save"})
	public String add(@Valid @ModelAttribute("company") CompanyModel model,
			final BindingResult bindingResult) {
		model.setId(0);
		if (bindingResult.hasErrors()) {
			return "company/company-add";
		}
		companyService.save(model);

		//roomModel = new RoomModel();
		return "redirect:/company/";
	}

}
