/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author firsov
 */
@Controller
public class RootController {
    
    @RequestMapping(value = "/")
    public String getPageIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/employee/")
    public String getPageTasks(Model model) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        model.addAttribute("val", employeeDao.getList());
        return "tasks";
    }
    
    @RequestMapping(value = "/employee/add/")
    public String getPageFormaEmployee(Model model){
        return "forma-employee";
    }
    
}
