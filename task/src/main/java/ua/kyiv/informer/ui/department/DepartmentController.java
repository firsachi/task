package ua.kyiv.informer.ui.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.service.DepartmentService;

/**
 *
 * @author firsov
 */
@Controller
public class DepartmentController extends CoreDepartmentController {

	@Autowired
	public DepartmentController(@Qualifier("departmentService") DepartmentService departmentService) {
		super(departmentService, "department-table");
	}

	@PreAuthorize("hasAnyAuthority('department:read')")
	@RequestMapping
	public String departmentsPage(Model model) {
		model.addAttribute("departments", getDepartmentService().getList("allDepartments"));
		return getUrl();
	}

	/*
	@Autowired
	private CompanyService companyService;
	
    @Autowired
    private DepartmentService departmentService;
    @ModelAttribute("departments")
    public List<DepartmentModel> getAllDepartments(){
    	return departmentService.getList("allDepartments");
    }
    @ModelAttribute("companiesList")
    public Set<CompanyModel> companiesList(ModelMap model) {
    	model.addAttribute("selectedDepartment", new DepartmentFormModel());
    	return companyService.all(false);
    }
    
    @RequestMapping
    public String getPageDepartment(){
        return "department/department";
    }
    
    @GetMapping(path = {"/add", "add/"})
    public String getPegeAdd(ModelMap model){
    	DepartmentFormModel department = new DepartmentFormModel();
    	model.addAttribute("department", department);
        return "department/department-add";
    }
    
    @PostMapping(path = {"/add", "add/"}, params = { "save" })
	public String getSubmitPage(@Valid @ModelAttribute("department") DepartmentFormModel model, BindingResult bindingResult) {
		model.setId(0);
		bindingResult = validate(bindingResult, model);
		if (bindingResult.hasErrors()) {
			return "department/department-add";
		}
		departmentService.save(model);
		return "redirect:/department/";
	}
    
    @GetMapping(value = "/edit/{id}")
    public String getPageForma( @PathVariable int id, ModelMap model ){
    	model.addAttribute("department", departmentService.getId(id));
        return "department/department-edit";
    }
    
    @PostMapping(value = "/edit/{id}", params = { "save" })
    public String getPageSubmit(@Valid @ModelAttribute("department") DepartmentFormModel model, BindingResult bindingResult) {
    	bindingResult = validate(bindingResult, model);
    	if (bindingResult.hasErrors()) {
			return "department/department-edit";
		}
    	departmentService.update(model);
		return "redirect:/department/";
    }
    
    private BindingResult validate(BindingResult bindingResult, DepartmentFormModel model) {
    	Map<String, Boolean> resultExists = departmentService.findQnique(model);
		if (!resultExists.get(model.getName())) {
			bindingResult.rejectValue("name","unique.value.violation");
		}
		return bindingResult;
    }
    		
    @GetMapping(path = "/selectedDepartment/{id}")
    public String deletePage(@PathVariable Integer id, final ModelMap model){
    	model.addAttribute("selectedDepartment", departmentService.getId(id));
    	return "fragments/department-fargment :: deleteModalWindow";
    }
    
    @PostMapping(path = {"/delete", "delete/", "/delete/"})
	public String getPageDelete(@ModelAttribute("selectedDepartment") DepartmentFormModel model) {
		departmentService.delete(model);
		return "redirect:/department/";
	}


	 */
}
