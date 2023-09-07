package ua.kyiv.informer.ui.employee;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.rest.employee.EmployeeModel;

@Controller
@SessionAttributes(value = {"employee"}, types = {EmployeeModel.class})
public class EmployeeEditController extends CoreEmployeeController{

    private final EmployeeModelAttribute employeeModelAttribute;

    public EmployeeEditController(EmployeeService employeeService, EmployeeModelAttribute employeeModelAttribute) {
        super(employeeService, "employee/employee-fragment :: employee-edit");
        this.employeeModelAttribute = employeeModelAttribute;
    }

    @ModelAttribute
    public void setModelAttributeDefault(final Model model){
        employeeModelAttribute.getAttributes(model);
    }

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping(path = {"/edit/{id}", "edit/{id}/"})
    public String editEmployeePage(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeeService.getId(id));
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @PostMapping(path = {"edit/{id}/", "/edit/{id}"})
    public String submitEdit(@Valid @ModelAttribute("employee")EmployeeModel employeeModel, BindingResult bindingResult, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return getUrl();
        } else {
            employeeService.update(employeeModel);
            sessionStatus.isComplete();
            return getRedirect();
        }
    }
}
