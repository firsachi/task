/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.PhoneDao;
import kievreclama.task.dao.PostDao;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.dao.impl.PhoneDaoImpl;
import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/employee/")
public class EmployeeController {
    
    @RequestMapping(value = "/")
    public String getPageTasks(Model model) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        model.addAttribute("employees", employeeDao.getList());
        
        return "employees";
    }   
    @RequestMapping(
            
            value = "/form"
    )
    public String getPageFormaEmployee(Model model, @RequestParam(name = "id") String id) throws SQLException{
        Integer i = new Integer(id);
        if (i != 0){
            EmployeeDao employeeDao = new EmployeeDaoImpl();
            Employee employee = new Employee();
            employee.setId(i);
            model.addAttribute("employee", employeeDao.find(employee));
        }
        PostDao postDao = new PostDaoImpl();
        model.addAttribute("listPost", postDao.list());
        PhoneDao phoneDao = new PhoneDaoImpl();
        model.addAttribute("phones", phoneDao.list());
        return "form-employee";
    }
 
}
