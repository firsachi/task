package informer.old;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import informer.model.PhoneModel;
import ua.kyiv.informer.logic.PhoneService;
import ua.kyiv.informer.repository.PhoneDaoImpl;

@RequestMapping("/phone/")
@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private PhoneDaoImpl phoneDao;
	
	@RequestMapping
	public String pagePtones(Model model) {
		model.addAttribute("phones", phoneDao.byList("allPhone"));
		return "phone";
	}

	@RequestMapping("/add")
	public ModelAndView addPhone() {
		ModelAndView model = new ModelAndView();
		model.setViewName("form-phone-add");
		model.addObject("phone", new PhoneModel());
		return model;
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView uodate(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("form-phone-edit");
		model.addObject("phone", phoneService.byId(id));
		return model;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String submit(@ModelAttribute("phone") @Valid PhoneModel phone, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "form-phone-add";
        }
		if (phone.getId() == 0) {
			phoneService.add(phone);
		}else {
			phoneService.update(phone);
		}
		return "redirect:../phone/";
	}
}
