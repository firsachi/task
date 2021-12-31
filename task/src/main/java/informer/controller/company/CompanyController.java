package informer.controller.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
	
	@GetMapping(path = {"company/", "/company"})
	public String pageCompany() {
		return "company/company";
	}

}
