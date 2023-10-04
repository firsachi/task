package ua.kyiv.informer.ui.room;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kyiv.informer.logic.service.RoomService;

/**
 * @author firsov
 *
 */
@RequestMapping(path = {"/room/", "room/"})
public abstract class CoreRoomController {

	private final RoomService roomService;

	private final String URL_PATCH = "room/room";

	private final  String REDIRECT = "redirect:/room/";

	public CoreRoomController(@Qualifier("roomService")RoomService roomService) {
		this.roomService = roomService;
	}

	@ModelAttribute("nameFragment")
	public abstract String getNameFragment();

	public  String getURL_PATCH(){
		return this.URL_PATCH;
	}

	public String getREDIRECT(){
		return this.REDIRECT;
	}

	public RoomService getRoomService() {
		return  this.roomService;
	}

}
