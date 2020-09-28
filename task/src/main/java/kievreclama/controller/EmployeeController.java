/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.controller;

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

import kievreclama.controller.emploees.FormaEmployee;
import kievreclama.task.web.EmployeeService;
import kievreclama.task.web.models.EmployeeModel;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends FormaEmployee{
    
    @Autowired
    private EmployeeService employeeService;
    
    @ModelAttribute("allEmployee")
    public List<EmployeeModel> allEmployee(){
    	return employeeService.getList("employees");
    }
     
    @RequestMapping
    public String getPageTasks(Model model){
        return "employees";
    }
    
    @GetMapping(value = "/add")
	public String getPageAddEmployee() {
		return "employee-add";
	}

	@PostMapping(value = "/add", params = { "save" })
	public String getPageFormAdd(@Valid @ModelAttribute("employee") EmployeeModel employeeModel,
			final BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "employee-add";
		}
		employeeService.save(employeeModel);
		this.employee = new EmployeeModel();
		return "redirect:/employee/";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String getEditPage(@PathVariable int id, ModelMap model) {
		model.addAttribute("employee", employeeService.getId(id));
		return "employee-edit";
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
    
}
