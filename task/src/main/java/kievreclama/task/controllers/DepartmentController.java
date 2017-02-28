/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.controllers.models.ModelDepartment;
import kievreclama.task.entity.Department;
import kievreclama.task.web.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/private/department/")
public class DepartmentController {
    
    private final int IS_NEW = 0;
    
    @Autowired
    private DepartmentService departmentService;
    
    @RequestMapping
    public String getPageDepartment(Model model){
        model.addAttribute("departments", departmentService.getList("allDepartments"));
        return "department";
    }
    
    @RequestMapping(value = "/add")
    public ModelAndView getPegeAdd(){
        //ModelAndView model = new ModelAndView("form-department-add", NAME_MODEL_FORM, new ModelDepartment());
    	
        return new ModelAndView();
    }
    /*
    @GetMapping(value = "/edit{id}")
    public ModelAndView getPageForma( @PathVariable Integer id ) throws SQLException{
        ModelDepartment modelDepartment = new ModelDepartment();
        if ( id != IS_NEW ){
            modelDepartment = fillDepartment(departmentDao.find(id));
        }
        ModelAndView model = new ModelAndView("form-department-edit", NAME_MODEL_FORM, modelDepartment);
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute(NAME_MODEL_FORM)ModelDepartment modelDepartment) throws SQLException{
        action(modelDepartment);
        return "redirect:../department/";
    }
    */
    
}
