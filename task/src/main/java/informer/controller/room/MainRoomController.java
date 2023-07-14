/**
 * 
 */
package informer.controller.room;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.kyiv.informer.logic.service.RoomServiceImpl;
import ua.kyiv.informer.rest.RoomModel;

/**
 * @author firsov
 *
 */
public abstract class MainRoomController {
	
	protected RoomModel roomModel;
	
	@Autowired
	protected RoomServiceImpl roomService;
	
	@ModelAttribute("room")
	public RoomModel getModel() {
		return roomModel;
	}
	
	@PostConstruct
	public void init() {
		this.roomModel = new RoomModel();
	}

}
