/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.TaskDao;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.dao.impl.TaskDaoImpl;
import kievreclama.task.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/private/tasks/")
public class TtaskController {
    
    @RequestMapping(name = "/")
    private String getPageTasks(HttpServletRequest request, Model model) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = employeeDao.find(request.getUserPrincipal().getName());
        model.addAttribute("employee", employee);
        return "user-task";
    }
}
