/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import kievreclama.task.web.PostService;
import kievreclama.task.web.models.PostModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/post")
public class PostController {
    
    private final String NAME_MODEL = "modelPost";
    
    @Autowired
    private PostService postSercice;
    
    private final String[] HEFT_POST = {"1.0","1.1","2.0","2.1","3.0","3.1","4.0","4.1","5.0","5.1","6.0","6.1","7.0","7.1","8.0","8.1","9.0","9.1"};
    
    @RequestMapping
    public String getPagePost(Model model){
        model.addAttribute("position", postSercice.getList("posts"));
        return "post";
    }
    
    @RequestMapping(value = "add")
    public ModelAndView getPageFormDeparmentAdd(){
        ModelAndView model = new ModelAndView("form-post-add", NAME_MODEL, new PostModel());
        model.addObject("HEFT_POST", HEFT_POST);
        return model;
    }
    
    @GetMapping(value = "edit{id}")
    public ModelAndView getPagesFormCompany( @PathVariable int id ){
        ModelAndView model = new ModelAndView("form-post-edit", NAME_MODEL, postSercice.getId(id));
        model.addObject("HEFT_POST", HEFT_POST);
        return model;
    }
    
    @GetMapping(value = "delete{id}")
    public String delete( @PathVariable int id ){
    	postSercice.delete(id);
    	return "redirect:../post/";
    }
    
    @RequestMapping(value = "/save")
    public String submit(@ModelAttribute(NAME_MODEL)PostModel postModel){
    	int isNew = 0;
    	if(postModel.getId() == isNew){
    		postSercice.save(postModel);
    	}else{
    		postSercice.update(postModel);
    	}
        return "redirect:../post/";
    }
}
