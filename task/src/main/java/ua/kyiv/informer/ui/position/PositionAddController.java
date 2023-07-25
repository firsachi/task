package ua.kyiv.informer.ui.position;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PositionAddController extends CorePositionController {

	public PositionAddController() {
		super("position-add");
	}

	@PreAuthorize("hasAnyAuthority('position:write')")
	@GetMapping(path = {"/add", "add/"})
	public String pageAdd(ModelMap model) {
    	model.addAttribute("position", new PositionModel());
		return getUrl();
	}

	@PreAuthorize("hasAnyAuthority('position:write')")
	@PostMapping(path = {"/add", "add/"}, params = { "save" })
	public String submitAddPosition(@Valid @ModelAttribute("position") PositionModel model,
			final BindingResult bindingResult) {
		model.setId(0);
		if (validForm(model, bindingResult)) {
			return getUrl();
		}
		else {
			positionService.save(model);
			return getRedirect();
		}
	}

}
