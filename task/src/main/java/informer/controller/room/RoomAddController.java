/**
 * 
 */
package informer.controller.room;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.rest.RoomModel;

/**
 * @author firsov
 *
 */
@Controller
@RequestMapping(value = "/room")
public class RoomAddController extends MainRoomController {

	@GetMapping(value = "/add")
	public String pageAdd() {
		return "room/room-add";
	}
	
	@PostMapping(value = "/add", params = {"save"})
	public String submitAdd(@Valid @ModelAttribute("room") RoomModel model,
			final BindingResult bindingResult) {
		model.setId(0);
		if (bindingResult.hasErrors()) {
			return "fragments/room-add";
		}
		roomService.save(model);
		roomModel = new RoomModel();
		return "redirect:/room/";
	}

}
