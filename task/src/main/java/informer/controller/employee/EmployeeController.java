/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.controller.employee;

import java.util.List;

import javax.validation.Valid;

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

import informer.model.EmployeeModel;
import ua.kyiv.informer.logic.EmployeeService;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(path = {"/employee", "employee/"})
public class EmployeeController extends FormaEmployee{
    
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
        return "employee/employees";
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
	
	@PostMapping(value = "/edit/{id}", params = { "save" })
	public String getPageFormUpdate(@Valid @ModelAttribute("employee") EmployeeModel employeeModel,
			final BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "employee-edit";
		}
		employeeService.update(employeeModel);
		this.employee = new EmployeeModel();
		return "redirect:/employee/";
	}
	
	@GetMapping(value = "/selectedEmployee/{id}")
	public String getPadeDelete(@PathVariable int id, @ModelAttribute("selectEmployee") EmployeeModel employee, ModelMap model) {
		model.addAttribute("selectEmployee", employeeService.getId(id));
		return "employees :: viewDeleteEmployee";
	}
	
	@PostMapping(value = "/delete/{id}", params = { "save" })
	public String getPageDelete(@ModelAttribute("selectEmployee") EmployeeModel employeeModel, ModelMap model) {
		employeeService.delete(employeeModel.getId());
		return "redirect:/employee/";
	}
    
}
