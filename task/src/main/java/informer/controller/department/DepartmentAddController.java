/**
 * 
 */
package informer.controller.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
