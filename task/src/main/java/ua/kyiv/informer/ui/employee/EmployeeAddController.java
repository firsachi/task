package ua.kyiv.informer.ui.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.logic.service.DepartmentService;
import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.rest.department.DepartmentModel;
import ua.kyiv.informer.rest.employee.EmployeeModel;
import ua.kyiv.informer.ui.company.CompanyModel;

import java.util.HashSet;
import java.util.Set;

@Controller
public class EmployeeAddController extends CoreEmployeeController {

    private final CompanyService companyService;

    private final DepartmentService departmentService;

    @Autowired
    public EmployeeAddController(EmployeeService employeeService, CompanyService companyService, DepartmentService departmentService) {
        super(employeeService, "employee-add");
        this.companyService = companyService;
        this.departmentService = departmentService;
    }

    @ModelAttribute("companies")
    public Set<CompanyModel> allCompany() {
        return new HashSet<>(companyService.all(false));
    }

    @ModelAttribute("departments")
    public Set<DepartmentModel> departments() {
        return new HashSet<>(departmentService.getList("department.disableFalse"));
    }

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping(path = {"add/", "/add"})
    public String pageAddEmployee(Model model) {
        model.addAttribute("employee", new EmployeeModel());
        return getUrl();
    }

}
