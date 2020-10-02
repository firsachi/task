package kievreclama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import kievreclama.task.web.RoomService;
import kievreclama.task.web.models.RoomModel;


@Controller
@RequestMapping("/room/")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@ModelAttribute("allRooms")
	public List<RoomModel> allRooms(){
		return roomService.allRoom("allRooms");
	}
	
	@RequestMapping
	public String roomPage(Model model) {
		return "room/rooms";
	}
	
}
