/**
 * 
 */
package informer.controller.department;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.DepartmentModel;

/**
 * @author firsov
 *
 */
@Controller
@RequestMapping(value = "/department/")
public class DepartmentAddController extends MainDepartment {
	
	@GetMapping(value = "/add")
    public String getPegeAdd(){
        return "department/department-add";
    }
	
	@PostMapping(value = "/add", params = { "save" })
	public String getSubmitPage(@Valid @ModelAttribute("department") DepartmentModel model,
			final BindingResult bindingResult) {
		model.setId(0);
		if (bindingResult.hasErrors()) {
			return "department/department-add";
		}
		departmentService.save(model);
		departmentModel = new DepartmentModel();
		return "redirect:/departmet/";
	}

}
