/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.controller.department;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.DepartmentModel;
import informer.service.DepartmentService;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/department/")
public class DepartmentController {
    
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
    
}
