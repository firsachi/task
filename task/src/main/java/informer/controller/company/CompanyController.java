package informer.controller.company;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.CompanyModel;
import informer.service.CompanyService;

@Controller
@RequestMapping(path = {"company/", "/company"})
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@ModelAttribute("companies")
	public List<CompanyModel> allCompany() {
		return companyService.all("allCompany");
	}		
	
	@GetMapping
	public String showCompany() {
		return "company/company";
	}
	
	@GetMapping(path = {"add", "/add/"})
	public String pageCompanyAdd(ModelMap model) {
		model.addAttribute("company", new CompanyModel());
		return "company/company-add";
	}
	
	@PostMapping(path = {"add", "/add/"},  params = {"save"})
	public String add(@Valid @ModelAttribute("company") CompanyModel model,
			final BindingResult bindingResult) {
		model.setId(0);		
		if (companyService.save(model)) {
			bindingResult.rejectValue("nameCompany","unique.value.violation");
		}
		if (bindingResult.hasErrors()) {
			return "company/company-add";
		}else {
			
			return "redirect:/company/";
		}
	}
	
	@GetMapping(path = {"edit/{id}","/edit/{id}", "/edit/{id}/", "edit/{id/}" })
	public String pageEdit(@PathVariable int id, ModelMap model) {
		model.addAttribute("company", companyService.byId(id));
		return "company/company-edit";
	}
	
	@PostMapping(path = {"edit/{id}","/edit/{id}", "/edit/{id}/", "edit/{id/}" },  params = {"save"})
	public String update(@Valid @ModelAttribute("company") CompanyModel model,
			final BindingResult bindingResult) {
		if (companyService.save(model)) {
			bindingResult.rejectValue("nameCompany","unique.value.violation");
		}
		if (bindingResult.hasErrors()) {
			return "company/company-edit";
		} else {
			companyService.update(model);
			return "redirect:/company/";
		}
	}

}
