package ua.kyiv.informer.ui.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.kyiv.informer.logic.service.DepartmentService;

/**
 *
 * @author firsov
 */
@Controller
public class DepartmentController extends CoreDepartmentController {

	public DepartmentController() {
		super( "department-table");
	}

	@PreAuthorize("hasAnyAuthority('department:read')")
	@RequestMapping
	public String departmentsPage(Model model) {
		model.addAttribute("departments", departmentService.getList("allDepartments"));
		return getUrl();
	}
}
