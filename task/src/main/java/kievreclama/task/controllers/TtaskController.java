/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import kievreclama.task.controllers.models.ModelTask;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.TaskDao;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.dao.impl.TaskDaoImpl;
import kievreclama.task.entity.Employee;
import kievreclama.task.entity.Task;
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
@RequestMapping(value = "/private/tasks/")
public class TtaskController {
    
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private TaskDao taskDao = new TaskDaoImpl();
    private final String[] URGENCY = {"1","2","3","4","5"};
     
    @RequestMapping(value = "/")
    public String getPageTasks(HttpServletRequest request, Model model) throws SQLException{
        employeeDao = new EmployeeDaoImpl();
        Employee employee = employeeDao.find(request.getUserPrincipal().getName());
        model.addAttribute("employee", employee);
        taskDao = new TaskDaoImpl();
        model.addAttribute("listTask", taskDao.list(employee.getId()));
        return "user-task";
    }
    
    @GetMapping(value = "{id}&{employeeId}")
    public ModelAndView getPageFormTask(@PathVariable Integer id, @PathVariable Integer employeeId) throws SQLException{
        ModelTask modelTask = new ModelTask();
        if(id != 0){
            modelTask = fiilModel(taskDao.findId(id));
        }
        ModelAndView model = new ModelAndView("form-task", "taskModel", modelTask);
        model.addObject("employee", employeeDao.find(employeeId));
        model.addObject("task", modelTask);
        model.addObject("urgency", URGENCY);
        return model;
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String submit(@ModelAttribute("taskModel")ModelTask modelTask) throws SQLException{
        Task task = new Task();
        task.setId(modelTask.getId());
        task.setDate(modelTask.getDate());
        task.setEmployee(employeeDao.find(modelTask.getId()));
        task.setNumber(modelTask.getNumber());
        task.setTask(modelTask.getTask());
        task.setUrgensy(new Integer(modelTask.getUrgensy()));
        action(task);
        return "redirect:../company/";
    }

    private void action(Task task) throws SQLException {
        if(task.getId() == 0){
            taskDao.add(task);
        }else{
            taskDao.update(task);
        }
    }

    private ModelTask fiilModel(Task task) {
       ModelTask result = new ModelTask();
       result.setId(task.getId());
       result.setEmployee(Integer.toString(task.getEmployee().getId()));
       result.setUrgensy(task.getUrgensy().toString());
       result.setNumber(task.getNumber());
       result.setTask(task.getTask());
       return result;
    }

}
