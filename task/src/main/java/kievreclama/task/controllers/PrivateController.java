/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String redirect(HttpServletRequest request){
        if(request.isUserInRole("private")){
            System.out.println(request.isUserInRole("private"));
            return "redirect:/private/employee/";
        }
        return "redirect:../";
    }
}
