/**
 * 
 */
package informer.controller.room;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import informer.model.RoomModel;
import informer.service.RoomService;

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
