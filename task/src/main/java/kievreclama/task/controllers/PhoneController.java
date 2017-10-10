package kievreclama.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kievreclama.task.entity.Phone;

@RequestMapping("/phone/")
@Controller
public class PhoneController {

	@RequestMapping("/add")
	public ModelAndView addPhone() {
		ModelAndView model = new ModelAndView();
		model.setViewName("form-phone-add");
		model.addObject("phone", new Phone());
		return model;
	}
}
