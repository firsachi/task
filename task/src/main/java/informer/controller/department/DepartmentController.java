/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.controller.department;


import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.CompanyModel;
import informer.model.DepartmentFormModel;
import informer.model.DepartmentModel;
import informer.service.CompanyService;
import informer.service.DepartmentService;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(path = {"department/", "/department"})
public class DepartmentController {
	
	private boolean deleteRecord = false;
    
	@Autowired
	private CompanyService companyService;
	
    @Autowired
    private DepartmentService departmentService;
    
    @ModelAttribute("departments")
    public List<DepartmentModel> getAllDepartments(){
    	return departmentService.getList("allDepartments");
    }
    @ModelAttribute("companiesList")
    public Set<CompanyModel> companiesList() {
    	return companyService.all(false);
    }
    
    @ModelAttribute("deleteRecord")
    public boolean deletePosition() {
    	return deleteRecord;
    }
    
    @RequestMapping
    public String getPageDepartment(){
        return "department/department";
    }
    
    @GetMapping(path = {"/add", "add/"})
    public String getPegeAdd( ModelMap model){
    	DepartmentFormModel department = new DepartmentFormModel();
    	model.addAttribute("department", department);
        return "department/department-add";
    }
    
    @PostMapping(path = {"/add", "add/"}, params = { "save" })
	public String getSubmitPage(@Valid @ModelAttribute("department") DepartmentFormModel model,
			final BindingResult bindingResult) {
		model.setId(0);
		
		Map<String, Boolean> resultExists = departmentService.findQnique(model);
		if (!resultExists.get(model.getName())) {
			bindingResult.rejectValue("name","unique.value.violation");
		}
		if (!resultExists.get(model.getAtsGroup())) {
			bindingResult.rejectValue("atsGroup","unique.value.violation");
		}
		if (bindingResult.hasErrors()) {
			return "department/department-add";
		}
		departmentService.save(model);
		return "redirect:/department/";
	}
    
    @GetMapping(value = "/delete/{id}")
    public String deletePage(@PathVariable Integer id, final ModelMap model){
    	deleteRecord = departmentService.delete(id);
    	return "redirect:/department/";
    }
    
}
