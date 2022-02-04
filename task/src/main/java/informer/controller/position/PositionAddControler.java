package informer.controller.position;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import informer.model.PositionModel;

@Controller
public class PositionAddControler extends MainPosition {
	
	@GetMapping(path = {"/add", "add/"})
	public String pageAdd(ModelMap model) {
    	model.addAttribute("position", new PositionModel());
		return "position/position-add";
	}

	@PostMapping(path = {"/add", "add/"}, params = { "save" })
	public String submitAddPosition(@Valid @ModelAttribute("position") PositionModel model,
			final BindingResult bindingResult) {
		model.setId(0);
		if (bindingResult.hasErrors()) {
			return "position/position-add";
		}
		positionService.save(model);
		return "redirect:/position/";
	}

}
