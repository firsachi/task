/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.PhoneDao;
import kievreclama.task.dao.PostDao;
import kievreclama.task.dao.RoomDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.dao.impl.PhoneDaoImpl;
import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.entity.Company;
import kievreclama.task.web.EmployeeService;
import kievreclama.task.web.models.EmployeeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/private/employee/")
public class EmployeeController {
    
    private final int isNew = 0;
    private final String NAME_MODEL ="modelEmployee";
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private final CompanyDao companyDao;
    private final PostDao postDao = new PostDaoImpl();
    private final PhoneDao phoneDao = new PhoneDaoImpl();
    private final RoomDao roomDao = new RoomDaoImpl();
    
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        this.companyDao = new CompanyDaoImpl(new Company());
    }
    
    @RequestMapping(value = "/")
    public String getPageTasks(Model model) throws SQLException{
        model.addAttribute("employees", employeeService.getList("allEmployee"));
        model.addAttribute("rooms", roomDao.list());
        return "employees";
    }
    
    @RequestMapping(value = "/add")
    public ModelAndView getPageFormAdd(){
    	ModelAndView model = new ModelAndView();
    	model.setViewName("form-employee-add");
    	model.addObject("modelEmployee", new EmployeeModel());
    	model.addAllObjects(employeeService.allCompnents());
        return model;
    }
    
    @GetMapping(value = "/edit{id}")
    public ModelAndView getPageFormaEmployee(@PathVariable Integer id) throws SQLException{
        ModelAndView model = new ModelAndView();
        return model;
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String submit(){
        return "redirect:../employee/";
    }

}
