package ua.kyiv.informer.ui.employee;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.rest.employee.EmployeeModel;

/**
 *
 * @author firsov
 */
@Controller
public class EmployeeControllerOld extends FormaEmployee {
    
    @Autowired
    private EmployeeService employeeService;
    
    @ModelAttribute("allEmployee")
    public List<EmployeeModel> allEmployee(){
    	return employeeService.getList("employees");
    }
    
    @ModelAttribute("selectEmployee")
    public EmployeeModel selectEmployee() {
    	return new EmployeeModel();
    }
     
    @RequestMapping
    public String getPageTasks(Model model){
        return "employee";
    }
    
    @GetMapping(path = {"/add", "add/"})
	public String getPageAddEmployee() {
		return "employee/employee-add";
	}

	@PostMapping(path = {"/add", "add/"}, params = { "save" })
	public String getPageFormAdd(@Valid @ModelAttribute("employee") EmployeeModel employeeModel,
			final BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "employee/employee-add";
		}
		employeeService.save(employeeModel);
		this.employee = new EmployeeModel();
		return "redirect:/employee/";
	}
	
	@GetMapping(path =  {"/edit/{id}", "edit/{id}", "/edit/{id}/", "edit/{id}/"})
	public String getEditPage(@PathVariable int id, ModelMap model) {
		model.addAttribute("employee", employeeService.getId(id));
		return "employee/employee-edit";
	}
	/*
	@PostMapping(value = "/edit/{id}", params = { "save" })
	public String getPageFormUpdate(@Valid @ModelAttribute("employee") EmployeeModel employeeModel,
			final BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "employee-edit";
		}
		employeeService.update(employeeModel, userAppDetails);
		this.employee = new EmployeeModel();
		return "redirect:/employee/";
	}
	*/

	@GetMapping(value = "/selectedEmployee/{id}")
	public String getPadeDelete(@PathVariable int id, ModelMap model) {
		model.addAttribute("employee", employeeService.getId(id));
		return "fragments/employee-fargment :: deleteModalWindow";
	}
	
	@PostMapping(path = {"/delete", "delete/", "/delete/"})
	public String getPageDelete(@ModelAttribute("employee") EmployeeModel employeeModel, ModelMap model) {
		employeeService.delete(employeeModel.getId());
		return "redirect:/employee/";
	}
    
}
