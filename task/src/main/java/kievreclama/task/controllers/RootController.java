/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.DepartmentDao;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.TaskDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.dao.impl.TaskDaoImpl;
import kievreclama.task.entity.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping
public class RootController {
    
    private final DepartmentDao departmentDao = new DepartmentDaoImpl();
    
    @RequestMapping(value = "/")
    public String getPageIndex(Model model) throws SQLException{
        TaskDao taskDao = new TaskDaoImpl();
        model.addAttribute("tasks", taskDao.list());
        return "index";
    }
    
    @RequestMapping(value = "/informer")
    public String getPageInformer(Model model) throws SQLException{
        CompanyDao companyDao = new CompanyDaoImpl();
        model.addAttribute("company", companyDao.getList());
        List<Department> list  = departmentDao.list();
        model.addAttribute("departments",list);
        listEmplyee(model, list.get(0).getId());
        model.addAttribute("department", list.get(0));
        return "informer";
    }
    
    @GetMapping(value = "/informer/{id}")
    public String getPage(Model model, @PathVariable Integer id) throws SQLException{
        CompanyDao companyDao = new CompanyDaoImpl();
        model.addAttribute("company", companyDao.getList());
        List<Department> list  = departmentDao.list();
        model.addAttribute("departments",list);
        listEmplyee(model, id);
        model.addAttribute("department", list.get(0));
        return "informer";
    }
    
    private Model listEmplyee(Model model, Integer number) throws SQLException{
        model.addAttribute("employees", departmentDao.find(number).getEmployees());
        return model;
    }
}
