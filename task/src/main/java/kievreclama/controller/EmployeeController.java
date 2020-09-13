/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.controller;

import kievreclama.task.web.CompanyService;
import kievreclama.task.web.DepartmentService;
import kievreclama.task.web.EmployeeService;
import kievreclama.task.web.PhoneService;
import kievreclama.task.web.PostService;
import kievreclama.task.web.RoomService;
import kievreclama.task.web.models.CompanyModel;
import kievreclama.task.web.models.DepartmentModel;
import kievreclama.task.web.models.EmployeeModel;
import kievreclama.task.web.models.PhoneModel;
import kievreclama.task.web.models.PostModel;
import kievreclama.task.web.models.RoomModel;

import java.util.List;

import javax.annotation.PostConstruct;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping
public class EmployeeController {
    
	private EmployeeModel employee;
	
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private PhoneService phoneService;
    
    @ModelAttribute("allCompany")
    public List<CompanyModel> allCompany(){
    	return companyService.getList("company");
    }

    @ModelAttribute("allEmployee")
    public List<EmployeeModel> allEmployee(){
    	return employeeService.getList("employees");
    }
    
    @ModelAttribute("allDepartment")
    public List<DepartmentModel> allDepartment() {
    	return departmentService.getList("department");
    }
    
    @ModelAttribute("allPost")
    public List<PostModel> allPost() {
    	return postService.getList("posts");
    }
    
    @ModelAttribute("allRoom")
    public List<RoomModel> allRoom(){
    	return roomService.allRoom("allRooms");
    }
    
    @ModelAttribute("allPhone")
    public List<PhoneModel> allPhone() {
    	return phoneService.getAll("allPhone");
    }
    
    @ModelAttribute("employee")
    private EmployeeModel employee() {
    	return employee;
    }
    
    @PostConstruct
    private void init() {
    	this.employee = new EmployeeModel();
    }
    
    @RequestMapping(value = "/employee")
    public String getPageTasks(Model model){
        return "employees";
    }
    
    @PostMapping(value = "/employee" , params = {"newEmployee"})
    public String getPageFormAdd(@Valid @ModelAttribute("employee") EmployeeModel employeeModel , final BindingResult bindingResult, ModelMap model){
    	if(bindingResult.hasErrors()) {
    		model.addAttribute("openNewEmployee", true);
    		return "employees";
    	}
    	employeeService.save(employeeModel);
    	this.employee = new EmployeeModel();
    	return "redirect:/employee/";
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
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("modelEmployee") EmployeeModel employeeModel){
    	int isNew = 0;
    	System.out.println(employeeModel);
    	if(employeeModel.getId() == isNew){
    		employeeService.save(employeeModel);
    	}else{
    		employeeService.update(employeeModel);
    	}
    	return "redirect:../employee/";
    }

}
