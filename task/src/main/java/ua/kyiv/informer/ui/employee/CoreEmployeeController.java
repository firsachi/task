package ua.kyiv.informer.ui.employee;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kyiv.informer.logic.service.EmployeeService;

@RequestMapping(path = {"employee/", "/employee"})
public abstract class CoreEmployeeController {

    protected EmployeeService employeeService;

    private final String NAME_FRAGMENT;

    public CoreEmployeeController(EmployeeService employeeService, String NAME_FRAGMENT) {
        this.employeeService = employeeService;
        this.NAME_FRAGMENT = NAME_FRAGMENT;
    }

    @ModelAttribute("nameFragment")
    public String getNAME_FRAGMENT(){
        return  this.NAME_FRAGMENT;
    }

    public String getUrl(){
        return "employee/employee";
    }

    public String getRedirect() {
        return "redirect:/employee/";
    }

    protected boolean isValidEmployee(){
        return true;
    }

}
