package ua.kyiv.informer.ui.employee;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.logic.service.DepartmentService;
import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.rest.employee.EmployeeModel;

@Controller
@SessionAttributes(value = {"employee"}, types = {EmployeeModel.class})
public class EmployeeEditController extends CoreEmployeeController{

    private final EmployeeModelAttribute employeeModelAttribute;

    private  final CompanyService companyService;

    public EmployeeEditController(EmployeeService employeeService, EmployeeModelAttribute employeeModelAttribute, CompanyService companyService) {
        super(employeeService, "employee/employee-fragment :: employee-edit");
        this.employeeModelAttribute = employeeModelAttribute;
        this.companyService = companyService;
    }

    @ModelAttribute
    public void setModelAttributeDefault(final Model model){
        employeeModelAttribute.getAttributes(model);
    }

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping(path = {"/edit/{id}", "edit/{id}/"})
    public String editEmployeePage(@PathVariable("id") int id, Model model){
        EmployeeModel employeeModel = employeeService.getId(id);
        model.addAttribute("employee", employeeModel);
        model.addAttribute("departments", companyService.getCompanyDepartments(employeeModel.getIdEnterprise()));
        return getUrl();
    }

    @Transactional
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @PostMapping(path = {"edit/{id}/", "/edit/{id}"})
    public String submitEdit(@Valid @ModelAttribute("employee")EmployeeModel employeeModel, final BindingResult bindingResult, Model model, SessionStatus sessionStatus) {
        employeeService.uniqueLoginEmail(employeeModel, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", companyService.getCompanyDepartments(employeeModel.getIdEnterprise()));
            return getUrl();
        } else {
            employeeService.update(employeeModel);
            sessionStatus.isComplete();
            return getRedirect();
        }
    }
}
