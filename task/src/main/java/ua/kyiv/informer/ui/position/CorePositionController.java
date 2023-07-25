package ua.kyiv.informer.ui.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.service.PositionService;

/**
 * @author firsov
 *
 */
@RequestMapping(path = { "/position", "position/" })
public abstract class CorePositionController {

	private final String[] HEFT_POST = { "1.0", "1.1", "2.0", "2.1", "3.0", "3.1", "4.0", "4.1", "5.0", "5.1", "6.0",
			"6.1", "7.0", "7.1", "8.0", "8.1", "9.0", "9.1" };

	@Autowired
	protected PositionService positionService;

	private final String nameFragment;

	public  CorePositionController(String nameFragment){
		this.nameFragment = nameFragment;
	}

	@ModelAttribute("nameFragment")
	public String getNameFragment() {
		return  this.nameFragment;
	}
	@ModelAttribute("allHeft")
	public String[] getHeft() {
		return HEFT_POST;
	}


	protected String getUrl(){
		return "position/position";
	}

	protected String getRedirect() {
		return "redirect:/position/";
	}

	protected boolean validForm(PositionModel model, BindingResult bindingResult) {
		if (positionService.isUnique(model)){
			bindingResult.rejectValue("namePosition", "unique.value.violation");
		}
		return bindingResult.hasErrors();
	}

}
