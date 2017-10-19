package kievreclama.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.RoomDao;

@Controller
@RequestMapping("/room/")
public class RoomController {
	
	@Autowired
	private FactoryDao factoryDao;
	
	@RequestMapping
	public String roomPage(Model model) {
		RoomDao roomDao = factoryDao.createRoomDao();
		model.addAttribute("rooms", roomDao.all());
		return "room";
	}

}
