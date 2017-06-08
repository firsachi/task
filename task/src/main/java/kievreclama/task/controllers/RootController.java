/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kievreclama.task.web.models.UserModel;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping
public class RootController {
	
	@Autowired
	private UserDetailsService userService;
    
    
    @RequestMapping(value = "/")
    public String getPageIndex(Model model){
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("login");
        return model;
    }
    
    @RequestMapping(value="autch", method = RequestMethod.POST)
    public String autch(HttpServletRequest request){
    	System.out.println(request.getParameter("username"));
    	return "post";
    }
}
