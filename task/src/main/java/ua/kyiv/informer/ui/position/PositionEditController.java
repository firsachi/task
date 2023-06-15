/**
 * 
 */
package ua.kyiv.informer.ui.position;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author firsov
 *
 */
@Controller
public class PositionEditController extends MainPosition {

    @ModelAttribute("nameFragment")
    public String getNameFragment() {
        return 	"form-edit";
    }
	
    @GetMapping(path = {"/edit/{id}", "edit/{id}"})
    public String getPagesFormCompany( @PathVariable int id, ModelMap model ){
    	model.addAttribute("position", positionService.getId(id));
        return "position/position";
    }
    
    @PostMapping(path = {"/edit/{id}", "edit/{id}"})
    public String submitUpadtePosition(@Valid @ModelAttribute("position") PositionModel model, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
			return "position/position";
		}
    	positionService.update(model);
    	return "redirect:/position/";
    }

}
