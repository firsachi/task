package ua.kyiv.informer.ui.room;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.service.RoomService;

@Controller
public class RoomAddController extends CoreRoomController{

    public RoomAddController(@Qualifier("roomService") RoomService roomService) {
        super(roomService);
    }

    @Override
    public String getNameFragment() {
        return "room-add";
    }

    @PreAuthorize("hasAnyAuthority('room:write')")
    @GetMapping(path = {"/add/", "/add"})
    public String addRoomPage( Model model){
        model.addAttribute("room", new RoomModel());
        return getURL_PATCH();
    }

    @PreAuthorize("hasAnyAuthority('room:write')")
    @PostMapping(path = {"/add/", "/add"})
    public String submitRoomAddPage(@Valid @ModelAttribute("room") RoomModel roomModel, final BindingResult bindingResult){
        roomModel.setId(0);
        if (bindingResult.hasErrors()) {
            return getURL_PATCH();
        }
        else {
            getRoomService().save(roomModel);
            return getREDIRECT();
        }
    }

}
