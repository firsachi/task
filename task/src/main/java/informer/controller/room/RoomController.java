package informer.controller.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.RoomModel;
import informer.service.RoomService;

@Controller
@RequestMapping("/room/")
public class RoomController {
	
	private boolean deleteRoom = false;
	
	protected RoomModel room;
	
	@Autowired
	private RoomService roomService;
	
	@ModelAttribute("allRooms")
	public List<RoomModel> allRooms(){
		return roomService.allRoom("allRooms");
	}
	
	@ModelAttribute("room")
	public RoomModel getRoom() {
		return room;
	}
	
	@ModelAttribute("deleteRoom")
    public boolean deletePosition() {
    	return deleteRoom;
    }
	
	@GetMapping
	public String roomPage(Model model) {
		room = new RoomModel();
		deleteRoom=false;
		return "room/rooms";
	}
	
    @GetMapping(value = "/delete/{id}")
    public String delete( @PathVariable Integer id, final ModelMap model ){
    	if (roomService.delete(id)) {
    		return "redirect:/room/";
    	}
    	deleteRoom = true;
    	return "redirect:/room/";
    }
	
}
