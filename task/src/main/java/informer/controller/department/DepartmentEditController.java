/**
 * 
 */
package informer.controller.department;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    @GetMapping(value = "/delete/{id}")
    public String deletePage(@PathVariable int id ){
    	departmentService.delete(id);
    	return "redirect:../../department/";
    }

}
