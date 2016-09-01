/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/private/")
public class PrivateController {
    
    @RequestMapping
    public String redirect(HttpServletRequest request) throws SQLException{
        System.out.println(request.isUserInRole("employees"));
        if(request.isUserInRole("employee")){
            return "redirect:/private/employee/";
        }else if(request.isUserInRole("private")){
            return "redirect:/private/tasks/";
        }else{
            return "redirect:../";
        }
    }
}
