/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import kievreclama.task.controllers.models.ModelEmployee;
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
@RequestMapping(value = "/private/employee/")
public class EmployeeController {
    
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private CompanyDao companyDao = new CompanyDaoImpl();
    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private PostDao postDao = new PostDaoImpl();
    private PhoneDao phoneDao = new PhoneDaoImpl();
    private RoomDao roomDao = new RoomDaoImpl();
    
    @RequestMapping
    public String getPageTasks(Model model) throws SQLException{
        model.addAttribute("employees", employeeDao.getList());    
        return "employees";
    }   
    
    @GetMapping(value = "/{id}")
    public ModelAndView getPageFormaEmployee(@PathVariable Integer id) throws SQLException{
        ModelAndView model = new ModelAndView("form-employee", "modelEmployee", new ModelEmployee());
        if (id != 0){
            Employee employee = employeeDao.find(id);
            ModelEmployee modelEmployee = new ModelEmployee();
            modelEmployee.setId(employee.getId());
            modelEmployee.setDepartment(employee.getDepartment().getId());
            modelEmployee.setEmail(employee.getEmail());
            modelEmployee.setEnterprise(employee.getEnterprise().getId());
            modelEmployee.setName(employee.getName());
            modelEmployee.setPatronymic(employee.getPatronymic());
            modelEmployee.setPhone(employee.getPhone().getId());
            modelEmployee.setPost(employee.getPost().getId());
            modelEmployee.setNumberRoom(employee.getRoom().getId());
            modelEmployee.setSurname(employee.getSurname());
            model.addObject("modelEmployee", modelEmployee);
        }
        model.addObject("listCompany", companyDao.getList());
        model.addObject("listDepartment", departmentDao.list());
        model.addObject("listPost", postDao.list());
        model.addObject("numberRoom", roomDao.list());
        model.addObject("listPhone", phoneDao.list());
        return model;
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String submit( @ModelAttribute("modelEmployee") @Valid ModelEmployee modelEmployee) throws SQLException{
        Employee employee = new Employee();
        employee.setId(modelEmployee.getId());
        employee.setName(modelEmployee.getName());
        employee.setSurname(modelEmployee.getSurname());
        employee.setPatronymic(modelEmployee.getPatronymic());
        employee.setEmail(modelEmployee.getEmail());
        employee.setPhone(phoneDao.find(modelEmployee.getPhone()));
        employee.setDepartment(departmentDao.find(modelEmployee.getDepartment()));
        employee.setRoom(roomDao.find(modelEmployee.getNumberRoom()));
        employee.setPost(postDao.find(modelEmployee.getPost()));
        employee.setEnterprise(companyDao.find(modelEmployee.getEnterprise()));
        action(employee);
        return "redirect:../employee/";
    }

    private void action(Employee employee) {
        
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
