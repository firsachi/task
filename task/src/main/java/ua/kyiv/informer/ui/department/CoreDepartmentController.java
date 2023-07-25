package ua.kyiv.informer.ui.department;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import ua.kyiv.informer.logic.service.DepartmentService;

@RequestMapping(path = {"/department", "department/"})
public class CoreDepartmentController {

    private final DepartmentService departmentService;

    private  final String NAME_FRAGMENT;

    public CoreDepartmentController(DepartmentService departmentService, String NAME_FRAGMENT) {
        this.departmentService = departmentService;
        this.NAME_FRAGMENT = NAME_FRAGMENT;
    }

    public DepartmentService getDepartmentService() {
        return this.departmentService;
    }

    @ModelAttribute("nameFragment")
    public String getNameFragment() {
        return  this.NAME_FRAGMENT;
    }

    public String getUrl() {
        return  "department/department";
    }

    public String getRedirect() {
        return  "redirect:/department/";
    }

    protected boolean valideFormDepartment (DepartmentFormModel departmentFormModel, BindingResult bindingResult){
        if (getDepartmentService().isUnique(departmentFormModel)) {
            bindingResult.rejectValue("name", "unique.value.violation");
        }
        return bindingResult.hasErrors();
    }
}
