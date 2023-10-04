package ua.kyiv.informer.ui.department;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.ui.company.CompanyModel;

import java.util.HashSet;
import java.util.Set;


@Controller
public class DepartmentAddController extends CoreDepartmentController {

    private final CompanyService companyService;

    public DepartmentAddController(@Qualifier("companyService") CompanyService companyService) {
        super("department-add");
        this.companyService = companyService;
    }

    @ModelAttribute("companies")
    public Set<CompanyModel> checkboxMultiCompany() {
        return new HashSet<>(companyService.all(false));
    }

    @PreAuthorize("hasAnyAuthority('company:write')")
    @GetMapping(path = {"add/", "/add"})
    public String pageDepartmentAdd(Model model) {
        model.addAttribute("department", new DepartmentFormModel());
        return getUrl();
    }

    @PreAuthorize("hasAnyAuthority('company:write')")
    @PostMapping(path = {"add/", "/add"})
    public String submitDepartmentAdd(@Valid @ModelAttribute("department") DepartmentFormModel departmentFormModel, final BindingResult bindingResult) {
        departmentFormModel.setId(0);
        if (valideFormDepartment(departmentFormModel, bindingResult)) {
            return getUrl();
        }
        else {
            getDepartmentService().save(departmentFormModel);
            return getRedirect();
        }
    }

}
