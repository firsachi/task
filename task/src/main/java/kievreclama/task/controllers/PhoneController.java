package kievreclama.task.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kievreclama.task.entity.Phone;
import kievreclama.task.web.models.PhoneModel;

@RequestMapping("/phone/")
@Controller
public class PhoneController {

	@RequestMapping("/add")
	public ModelAndView addPhone() {
		ModelAndView model = new ModelAndView();
		model.setViewName("form-phone-add");
		model.addObject("phone", new PhoneModel());
		return model;
	}
	
	@RequestMapping(value = "/chech_login_page", method = RequestMethod.POST)
	public String checkphoneForm(@Valid @ModelAttribute("phone") Phone phone, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "form-phone-add";
        }else{
        	return "home";
        }
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String submit(@Valid Phone phone, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "form-phone-add";
        }
		return "redirect:../employee/";
	}
}
