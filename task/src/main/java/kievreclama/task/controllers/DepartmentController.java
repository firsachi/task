/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kievreclama.task.dao.DepartmentDao;
import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.entity.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/department/")
public class DepartmentController {
    
    @RequestMapping
    public String getPageDepartment(Model model) throws SQLException{
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        model.addAttribute("departments", departmentDao.list());
        return "department";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView getPageForma(@ModelAttribute(name = "id") String id) throws SQLException{
        Department department = new Department();
        if (!id.equals("0")){
            DepartmentDao departmentDao = new DepartmentDaoImpl();
            department = departmentDao.find(new Integer(id));
        }
        ModelAndView model = new ModelAndView("form-department", "department", department);
        return model;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute("department")Department department){
        action(department);
        return "redirect:../department/";
    }

    private void action(Department department) {
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        if (department.getId() == 0){
            try {
                departmentDao.add(department);
            } catch (SQLException ex) {
                Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                departmentDao.update(department);
            } catch (SQLException ex) {
                Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
