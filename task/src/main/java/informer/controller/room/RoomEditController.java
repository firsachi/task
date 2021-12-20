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

import informer.model.RoomModel;

/**
 * @author firsov
 *
 */
@Controller
@RequestMapping(value = "/room")
public class RoomEditController extends MainRoomController {
	
	@GetMapping(value = "/edit")
	public String pageEdit(Integer id) {
		return "room/rooms";
	}
	
	@PostMapping(value = "/edit/{id}", params = {"save"})
	public String submitAdd(@Valid @ModelAttribute("room") RoomModel model,
			final BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "room/room-add";
		}
		roomService.update(model);
		roomModel = new RoomModel();
		return "redirect:/room/";
	}

}
