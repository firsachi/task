package ua.kyiv.informer.ui.employee;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kyiv.informer.logic.service.EmployeeService;

@RequestMapping(path = {"employee/", "/employee"})
public abstract class CoreEmployeeController {

    protected EmployeeService employeeService;

    private final String BODY_FRAGMENT_NAME;

    public CoreEmployeeController(EmployeeService employeeService, String BODY_FRAGMENT_NAME) {
        this.employeeService = employeeService;
        this.BODY_FRAGMENT_NAME = BODY_FRAGMENT_NAME;
    }

    @ModelAttribute("titlepage")
    public String titlePage(){
        return "titleform.employee";
    }

    @ModelAttribute("componentManu")
    public String menu(){
        return  "templates/menu-admin :: menu-admin";
    }

    @ModelAttribute("bodyFragment")
    public String getBodyFragment(){
        return  this.BODY_FRAGMENT_NAME;
    }

    public String getUrl(){
        return "core-page";
    }

    public String getRedirect() {
        return "redirect:/employee/";
    }

    protected boolean isValidEmployee(){
        return true;
    }

}
