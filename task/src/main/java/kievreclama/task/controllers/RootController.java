/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.dao.TaskDao;
import kievreclama.task.dao.impl.TaskDaoImpl;
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
    public String getPageIndex(Model model) throws SQLException{
        TaskDao taskDao = new TaskDaoImpl();
        model.addAttribute("tasks", taskDao.list());
        return "index";
    }
}
