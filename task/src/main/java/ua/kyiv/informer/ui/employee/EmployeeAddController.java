package ua.kyiv.informer.ui.employee;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.rest.employee.EmployeeModel;

@Controller
public class EmployeeAddController extends CoreEmployeeController {

    private  final EmployeeModelAttribute employeeModelAttribute;

    @Autowired
    public EmployeeAddController(EmployeeService employeeService, EmployeeModelAttribute employeeModelAttribute) {
        super(employeeService, "employee/employee-fragment :: employee-add");
        this.employeeModelAttribute = employeeModelAttribute;
    }

    @ModelAttribute
    public void setModelAttributeDefault(final Model model){
        employeeModelAttribute.getAttributes(model);
    }

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @GetMapping(path = {"add/", "/add"})
    public String pageAddEmployee(Model model) {
        model.addAttribute("employee", new EmployeeModel());
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @PostMapping(path = {"add/", "/add"})
    public String submitPage(@Valid @ModelAttribute("employee") EmployeeModel employeeModel, final BindingResult bindingResult) {
        employeeModel.setId(0);
        if (bindingResult.hasErrors()){
            return getUrl();
        }else {
            employeeService.save(employeeModel);
            return getRedirect();
        }
    }

}
