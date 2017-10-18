package kievreclama.task.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kievreclama.task.entity.Phone;
import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.PhoneDao;
import kievreclama.task.web.PhoneService;
import kievreclama.task.web.models.PhoneModel;

@RequestMapping("/phone/")
@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private FactoryDao factoryDao;
	
	@RequestMapping
	public String pagePtones(Model model) {
		PhoneDao phones = factoryDao.createPhoneDao();
		model.addAttribute("phones", phones.getAll());
		return "phone";
	}

	@RequestMapping("/add")
	public ModelAndView addPhone() {
		ModelAndView model = new ModelAndView();
		model.setViewName("form-phone-add");
		model.addObject("phone", new PhoneModel());
		return model;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String submit(@ModelAttribute("phone") @Valid PhoneModel phone, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "form-phone-add";
        }
		phoneService.add(phone);
		return "redirect:../phone/";
	}
}
