/**
 * 
 */
package kievreclama.controller.room;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import kievreclama.task.web.RoomService;
import kievreclama.task.web.models.RoomModel;

/**
 * @author firsov
 *
 */
public abstract class MainRoomController {
	
	protected RoomModel roomModel;
	
	@Autowired
	protected RoomService roomService;
	
	@ModelAttribute("room")
	public RoomModel getModel() {
		return roomModel;
	}
	
	@PostConstruct
	public void init() {
		this.roomModel = new RoomModel();
	}

}
