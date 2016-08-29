/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.DepartmentDao;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.PhoneDao;
import kievreclama.task.dao.PostDao;
import kievreclama.task.dao.RoomDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.dao.impl.PhoneDaoImpl;
import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.entity.Employee;
import kievreclama.task.entity.Phone;
import kievreclama.task.entity.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/employee/")
public class EmployeeController {
    
    @RequestMapping
    public String getPageTasks(Model model) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        model.addAttribute("employees", employeeDao.getList());    
        return "employees";
    }   
    
    @GetMapping(value = "/{id}")
    public ModelAndView getPageFormaEmployee(@PathVariable Integer id) throws SQLException{
        ModelAndView model = new ModelAndView("form-employee", "employee", new Employee());
        if (id != 0){
            EmployeeDao employeeDao = new EmployeeDaoImpl();
            Employee employee = new Employee();
            employee.setId(id);
            model.addObject("employee", employeeDao.find(employee));
        }
        CompanyDao companyDao = new CompanyDaoImpl();
        model.addObject("listCompany", companyDao.getList());
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        model.addObject("listDepartment", departmentDao.list());
        PostDao postDao = new PostDaoImpl();
        model.addObject("listPost", postDao.list());
        RoomDao roomDao = new RoomDaoImpl();
        model.addObject("listRoom", roomDao.list());
        PhoneDao phoneDao = new PhoneDaoImpl();
        model.addObject("listPhone", phoneDao.list());
        return model;
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String submit(
            
            @RequestParam(value = "phone") Integer phone, @ModelAttribute("employee") @Valid Employee employee){
        System.out.println("dsasldf';lasd");
        //action(employee);
        return "redirect:../employee/";
    }

    private void action(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        if (employee.getId()==0){
            try {
                employeeDao.add(employee);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                employeeDao.update(employee);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
