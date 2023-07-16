package ua.kyiv.informer.ui.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.kyiv.informer.logic.service.RoomService;

@Controller
public class RoomController extends CoreRoomController {

	@Autowired
	public RoomController(@Qualifier("roomService") RoomService roomService) {
		super(roomService);
	}

	@Override
	public String getNameFragment() {
		return "room-table";
	}

	@GetMapping
	@PreAuthorize("hasAnyAuthority('room:read')")
	public String roomPage(Model model) {
		model.addAttribute("rooms", getRoomService().all("allRooms"));
		return getURL_PATCH();
	}

}
