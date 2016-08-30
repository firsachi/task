/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.dao.PostDao;
import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.entity.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/private/post/")
public class PostController {
    
    @RequestMapping
    public String getPagePost(Model model) throws SQLException{
        PostDao postDao = new PostDaoImpl();
        model.addAttribute("position", postDao.list());
        return "post";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getPagesFormCompany( @ModelAttribute(name = "id") String id) throws SQLException{
        ModelAndView modelAndView = new ModelAndView("form-post");
        if (!id.equals("0")){
            PostDao postDao = new PostDaoImpl();
            modelAndView.addObject("post", postDao.find(new Integer(id)));
            modelAndView.addObject("action", "Редагувати посаду");
        }else{
            modelAndView.addObject("action", "Нова посада");
            modelAndView.addObject("post", new Post());
        }
        String[] heftPost = {"1.0","1.1","2.0","2.1","3.0","3.1","4.0","4.1","5.0","5.1","6.0","6.1","7.0","7.1","8.0","8.1","9.0","9.1"};
        modelAndView.addObject("heftPost", heftPost);
        return modelAndView;
    }
    
    @RequestMapping(value = "/add")
    public String submit(@ModelAttribute("post")Post post) throws SQLException{
        action(post);
        return "redirect:../post/";
    }
    
    private void action(Post post) throws SQLException{
        PostDao postDao = new PostDaoImpl();
        if(post.getId() == 0){
            postDao.add(post);
        }else{
            postDao.update(post);
        }
    }
}
