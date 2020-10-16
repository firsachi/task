/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.controller.department;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import informer.model.DepartmentModel;
import informer.old.models.ModelDepartment;
import informer.service.DepartmentService;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/department/")
public class DepartmentController {
    
	private final String NAME_MODEL_FORM = "modelDepartment";
    
    @Autowired
    private DepartmentService departmentService;
    
    @ModelAttribute("departments")
    public List<DepartmentModel> getAllDepartments(){
    	return departmentService.getList("allDepartments");
    }
    
    @RequestMapping
    public String getPageDepartment(){
        return "department/department";
    }
    
    @RequestMapping(value = "/add")
    public ModelAndView getPegeAdd(){
        ModelAndView model = new ModelAndView("form-department-add", NAME_MODEL_FORM, new ModelDepartment());
        return model;
    }
    
    @GetMapping(value = "/edit/{id}")
    public ModelAndView getPageForma( @PathVariable int id ){
        DepartmentModel departmentModel = departmentService.getId(id);
        ModelAndView model = new ModelAndView("form-department-edit", NAME_MODEL_FORM, departmentModel);
        return model;
    }
    
    @GetMapping(value = "/delete/{id}")
    public String deletePage(@PathVariable int id ){
    	departmentService.delete(id);
    	return "redirect:../../department/";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute(NAME_MODEL_FORM) DepartmentModel departmentModel ) {
        int isNew = 0;
        if (departmentModel.getId() == isNew){
        	departmentService.save(departmentModel);
        }else{
        	departmentService.update(departmentModel);
        }
        return "redirect:../department/";
    }
    
}
