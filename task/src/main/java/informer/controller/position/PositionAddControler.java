package informer.controller.position;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.PositionModel;

@Controller
@RequestMapping(value = "/position")
public class PositionAddControler extends MainPosition{


	@GetMapping(value = "/add")
	public String getAddPage() {
		return "position/position-add";
	}

	@PostMapping(value = "/add", params = { "save" })
	public String submitAddPosition(@Valid @ModelAttribute("position") PositionModel model,
			final BindingResult bindingResult) {
		model.setId(0);
		if (bindingResult.hasErrors()) {
			return "position/position-add";
		}
		positionService.save(model);
		positionModel = new PositionModel();
		return "redirect:/position/";
	}

}
