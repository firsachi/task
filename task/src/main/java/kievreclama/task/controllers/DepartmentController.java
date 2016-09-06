/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.controllers.models.ModelDepartment;
import kievreclama.task.dao.DepartmentDao;
import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.entity.Department;
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
@RequestMapping(value = "/private/department/")
public class DepartmentController {
    
    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private final int IS_NEW = 0;
    private final String NAME_MODEL_FORM ="modelDepartment";
    
    @RequestMapping
    public String getPageDepartment(Model model) throws SQLException{
        model.addAttribute("departments", departmentDao.list());
        return "department";
    }
    
    @RequestMapping(value = "/add")
    public ModelAndView getPegeAdd(){
        ModelAndView model = new ModelAndView("form-department-add", NAME_MODEL_FORM, new ModelDepartment());
        return model;
    }
    
    @GetMapping(value = "/edit{id}")
    public ModelAndView getPageForma( @PathVariable Integer id ) throws SQLException{
        ModelDepartment modelDepartment = new ModelDepartment();
        if ( id != IS_NEW ){
            modelDepartment = fillDepartment(departmentDao.find(id));
        }
        ModelAndView model = new ModelAndView("form-department", NAME_MODEL_FORM, modelDepartment);
        return model;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute(NAME_MODEL_FORM)ModelDepartment modelDepartment) throws SQLException{
        action(modelDepartment);
        return "redirect:../department/";
    }
    
    private ModelDepartment fillDepartment(Department department){
        ModelDepartment model = new ModelDepartment();
        model.setId(department.getId());
        model.setName(department.getName());
        model.setPhone(department.getPhone());
        model.setFax(department.getFax());
        return model;
    }

    private void action(ModelDepartment modelDepartment) throws SQLException {
        Department department = new Department();
        department.setId(modelDepartment.getId());
        department.setName(modelDepartment.getName());
        department.setPhone(modelDepartment.getPhone());
        department.setFax(modelDepartment.getFax());
        if (modelDepartment.getId() == IS_NEW){
            departmentDao.add(department);
        }else{
            departmentDao.update(department);
        }
    }
}
