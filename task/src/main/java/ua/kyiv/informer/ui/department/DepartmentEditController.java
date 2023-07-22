package ua.kyiv.informer.ui.department;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.logic.service.DepartmentService;
import ua.kyiv.informer.ui.company.CompanyModel;

import java.util.HashSet;
import java.util.Set;

@Controller
@SessionAttributes(value = "department")
public class DepartmentEditController extends CoreDepartmentController {

    private final CompanyService companyService;

    @Autowired
    public DepartmentEditController(DepartmentService departmentService, CompanyService companyService) {
        super(departmentService, "department-edit");
        this.companyService = companyService;
    }

    @PreAuthorize("hasAnyAuthority('department:write')")
    @ModelAttribute("companies")
    public Set<CompanyModel> multiDepartment(){
        return new HashSet<>(companyService.all(false));
    }

    @PreAuthorize("hasAnyAuthority('department:write')")
    @GetMapping(path = {"/edit/{id}", "edit/{id}/"})
    public String editDepartmentPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", getDepartmentService().getId(id));
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('department:write')")
    @PostMapping(path = {"/edit/{id}", "edit/{id}/"})
    public String submitFormEdit(@Valid @ModelAttribute("department") DepartmentFormModel departmentFormModel, BindingResult bindingResult, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
             return  getUrl();
        } else {
             getDepartmentService().update(departmentFormModel);
             sessionStatus.setComplete();
             return getRedirect();
        }
    }
}
