/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import kievreclama.task.web.CompanyService;
import kievreclama.task.web.models.CompanyModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author firsachi
 */
@Controller
@RequestMapping(value = "/company/")
public class CompamyComtroler {

    @Autowired
    private CompanyService companyService;
    
    @RequestMapping(value = "/")
    public String getPagesCompany(Model model){
        model.addAttribute("company", companyService.getList("company"));
        return "company";
    }
    
    @RequestMapping(value = "/add")
    public ModelAndView getPagesFormAdd(){
        ModelAndView model = new ModelAndView("form-company-add", "enterprise", new CompanyModel());
        return model;
    }
    
    @GetMapping(value = "/edit{id}")
    public ModelAndView getPagesFormCompany( @PathVariable int id ){
        return new ModelAndView("form-company-edit", "enterprise", companyService.getId(id));
    }
    
    @GetMapping(value = "/delete{id}")
    public String getPageGeleteCompany(@PathVariable int id){
    	companyService.delete(id);
    	return "redirect:../company/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("enterprise") CompanyModel companyModel ){
    	int isNew = 0;
    	if (companyModel.getId() == isNew ){
            companyService.save(companyModel);
        }else{
            companyService.update(companyModel);
        }
        return "redirect:../company/";
    }

}
