package ua.kyiv.informer.ui.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.kyiv.informer.logic.service.EmployeeService;

@Controller
public class EmployeeController extends CoreEmployeeController {

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        super(employeeService, "employee/employee-fragment :: employee-table");
    }

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping
    public String pageEmployee(Model model) {
        model.addAttribute("employees", employeeService.getList("employees"));
        return getUrl();
    }

}
