package ua.kyiv.informer.ui.position;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author firsov
 *
 */
@Controller
@SessionAttributes(value = "department")
public class PositionEditController extends CorePositionController {

    public PositionEditController() {
        super("position-edit");
    }

    @PreAuthorize("hasAnyAuthority('position:write')")
    @GetMapping(path = {"/edit/{id}", "edit/{id}"})
    public String getPagesFormCompany( @PathVariable int id, ModelMap model ){
    	model.addAttribute("position", positionService.getId(id));
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('position:write')")
    @PostMapping(path = {"/edit/{id}", "edit/{id}"})
    public String submitUpdatePosition(@Valid @ModelAttribute("position") PositionModel model, final BindingResult bindingResult, SessionStatus sessionStatus) {
    	if (validForm(model, bindingResult)) {
            return getUrl();
        }
        else {
            positionService.update(model);
            sessionStatus.setComplete();
            return getRedirect();
        }
    }

}
