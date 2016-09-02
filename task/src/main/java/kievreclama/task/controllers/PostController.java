/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.controllers.models.ModelPost;
import kievreclama.task.dao.PostDao;
import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.entity.Post;
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
@RequestMapping(value = "/private/post/")
public class PostController {
    
    private PostDao postDao = new PostDaoImpl(); ;
    private final int isNew = 0;
    private final String NAME_MODEL = "modelPost";
    
    @RequestMapping
    public String getPagePost(Model model) throws SQLException{
        model.addAttribute("position", postDao.list());
        return "post";
    }
    
    @GetMapping(value = "/{id}")
    public ModelAndView getPagesFormCompany( @PathVariable Integer id ) throws SQLException{
        ModelPost modelPost = new ModelPost();
        String title = "Нова посада";
        if (id != isNew){
            modelPost = fillModell(postDao.find(id));
            title = "Редагувати посаду";
        }
        ModelAndView modelAndView = new ModelAndView("form-post", NAME_MODEL, modelPost);
        modelAndView.addObject("title", title);
        return modelAndView;
    }
    
    private ModelPost fillModell(Post post){
        ModelPost modelPost = new ModelPost();
        modelPost.setId(post.getId());
        modelPost.setName(post.getName());
        modelPost.setHeft(post.getHeft());
        return modelPost;
    }
    
    @RequestMapping(value = "/add")
    public String submit(@ModelAttribute(NAME_MODEL)ModelPost modelPost) throws SQLException{
        action(modelPost);
        return "redirect:../post/";
    }
    
    private void action(ModelPost modelPost) throws SQLException{
        Post post = new Post();
        post.setId(modelPost.getId());
        post.setName(modelPost.getName());
        post.setHeft(modelPost.getHeft());
        if(post.getId() == 0){
            postDao.add(post);
        }else{
            postDao.update(post);
        }
    }
}
