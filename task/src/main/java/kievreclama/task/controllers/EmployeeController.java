/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import kievreclama.task.web.EmployeeService;
import kievreclama.task.web.models.EmployeeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(value = "/employee")
    public String getPageTasks(Model model){
        model.addAttribute("employees", employeeService.getList("employees"));
        model.addAllAttributes(employeeService.allCompnents());
        return "employees";
    }
    
    @RequestMapping(value = "/add")
    public ModelAndView getPageFormAdd(){
    	ModelAndView model = new ModelAndView();
    	model.setViewName("form-employee-add");
    	model.addObject("modelEmployee", new EmployeeModel());
    	model.addAllObjects(employeeService.allCompnents());
        return model;
    }
    
    @GetMapping(value = "/edit/{id}")
    public ModelAndView getPageFormaEmployee(@PathVariable int id){
        ModelAndView model = new ModelAndView();
        model.setViewName("form-employee-edit");
        model.addObject("modelEmployee", employeeService.getId(id));
        model.addAllObjects(employeeService.allCompnents());
        return model;
    }
    
    @GetMapping(value = "/delete/{id}")
    public String deletePage(@PathVariable int id){
    	employeeService.delete(id);
    	return "redirect:../../employee/";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("modelEmployee") EmployeeModel employeeModel){
    	int isNew = 0;
    	if(employeeModel.getId() == isNew){
    		employeeService.save(employeeModel);
    	}else{
    		employeeService.update(employeeModel);
    	}
    	return "redirect:../employee/";
    }

}
