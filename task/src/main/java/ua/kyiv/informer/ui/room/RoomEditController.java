/**
 * 
 */
package ua.kyiv.informer.ui.room;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.support.SessionStatus;
import ua.kyiv.informer.logic.service.RoomService;

/**
 * @author firsov
 *
 */
@Controller
@SessionAttributes(value = "room")
public class RoomEditController extends CoreRoomController {

    @Autowired
    public RoomEditController(@Qualifier("roomService") RoomService roomService) {
        super(roomService);
    }

    @Override
    public String getNameFragment() {
        return "room-edit";
    }

    @PreAuthorize("hasAnyAuthority('room:write')")
    @GetMapping(path = {"/edit/{id}", "/edit/{id}/"})
    private String editRoomPage(@PathVariable("id") int idRoom, Model model) {
        model.addAttribute("room", getRoomService().byId(idRoom));
        return getURL_PATCH();
    }

    @PreAuthorize("hasAnyAuthority('room:write')")
    @PostMapping(path = {"/edit", "/edit/"})
    public String submitRoomEdit(@Valid @ModelAttribute("room") RoomModel roomModel, BindingResult bindingResult, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return getURL_PATCH();
        }
        else if (getRoomService().findRoomNumber(roomModel.getNumberRoom())) {
            sessionStatus.setComplete();
            getRoomService().update(roomModel);
            return getREDIRECT();
        }
        else {
            bindingResult.rejectValue("numberRoom", "unique.value.violation");
            return getURL_PATCH();
        }
    }

}
