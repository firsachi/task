/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/department/")
public class DepartmentController {
    
    @RequestMapping
    public String getPageDepartment(){
        return "department";
    }
}
