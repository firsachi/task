/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping
public class RootController {
    
    
    @RequestMapping(value = "/")
    public String getPageIndex(Model model){
        return "index";
    }
}
