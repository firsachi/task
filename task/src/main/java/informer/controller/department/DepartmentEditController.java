/**
 * 
 */
package informer.controller.department;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.DepartmentModel;

/**
 * @author firsov
 *
 */
@Controller
@RequestMapping(value = "/department/")
public class DepartmentEditController extends MainDepartment {
	
    @GetMapping(value = "/edit/{id}")
    public String getPageForma( @PathVariable int id, ModelMap model ){
    	model.addAttribute("department", departmentService.getId(id));
        return "department/department-edit";
    }
    
    @PostMapping(value = "/edit/{id}", params = { "save" })
    public String getPageSubmit(@Valid @ModelAttribute("department") DepartmentModel model,
			final BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
			return "department/department-edit";
		}
    	departmentService.update(model);
		departmentModel = new DepartmentModel();
		return "redirect:/department/";
    }

}
