package kievreclama.task.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.web.ServiceRoom;
import kievreclama.task.web.models.RoomModel;


@Controller
@RequestMapping("/room/")
public class RoomController {
	
	@Autowired
	private ServiceRoom serviceRoom;
	
	@Autowired
	private RoomDaoImpl roomDao;
	
	@RequestMapping
	public String roomPage(Model model) {
		model.addAttribute("rooms", roomDao.byList("allRooms"));
		return "room";
	}
	
	@RequestMapping(value = "add")
	public ModelAndView pageAdd() {
		ModelAndView model = new ModelAndView();
		model.setViewName("form-room-add");
		model.addObject("room", new RoomModel());
		return model;
	}
	
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView pageEdit(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("form-room-edit");
		model.addObject("room", serviceRoom.byId(id));
		return model;
	}
	
	@Transactional
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String submit(@ModelAttribute("room") @Valid RoomModel room, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "form-room-add";
        }	
		serviceRoom.add(room);
		return "redirect:../room/";
	}
	
	@Transactional
	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String submitUpdate(@ModelAttribute("room") @Valid RoomModel room, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "form-room-edit";
        }	
		serviceRoom.update(room);
		return "redirect:../../room/";
	}
	

}
