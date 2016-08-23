/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.entity.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/post/")
public class PostController {
    
    @RequestMapping
    public String getPagePost(){
        return "post";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView getPagesFormCompany( @ModelAttribute(name = "id") String id) throws SQLException{
        ModelAndView modelAndView = new ModelAndView("form-post");
        Post post = new Post();
        if (!id.equals("0")){
            
        }else{
            modelAndView.addObject("action", "Нова посада");
        }
        
        modelAndView.addObject("post", post);
        return modelAndView;
    }
    
    @RequestMapping(value = "/add")
    public String submit(@ModelAttribute("post")Post post){
        return "redirect:../post/";
    }
}
