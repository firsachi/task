package ua.kyiv.informer.ui.employee;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.rest.employee.EmployeeModel;

@Controller
public class EmployeeAddController extends CoreEmployeeController {

    private  final EmployeeModelAttribute employeeModelAttribute;

    private  final CompanyService companyService;

    public EmployeeAddController(EmployeeService employeeService, EmployeeModelAttribute employeeModelAttribute, CompanyService companyService) {
        super(employeeService, "employee/employee-fragment :: employee-add");
        this.employeeModelAttribute = employeeModelAttribute;
        this.companyService = companyService;
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

    @Transactional
    @PreAuthorize("hasAnyAuthority('employee:write')")
    @PostMapping(path = {"add/", "/add"})
    public String submitPage(@Valid @ModelAttribute("employee") EmployeeModel employeeModel, final BindingResult bindingResult, Model model) {
        employeeModel.setId(0);
        employeeService.uniqueLoginEmail(employeeModel, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("departments", companyService.getCompanyDepartments(employeeModel.getIdEnterprise()));
            return getUrl();
        }else {
            employeeService.save(employeeModel);
            return getRedirect();
        }
    }

}
