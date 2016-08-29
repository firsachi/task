/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.entity.Enterprise;
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
    
    @RequestMapping(value = "/")
    public String getPagesCompany(Model model) throws SQLException{
        CompanyDao companyDao = new CompanyDaoImpl();
        model.addAttribute("company", companyDao.getList());
        return "company";
    }
    
    @GetMapping(value = "/{id}")
    public ModelAndView getPagesFormCompany( @PathVariable Integer id ) throws SQLException{
        Enterprise enterprise = new Enterprise();
        if (!id.equals(0)){
            CompanyDao companyDao = new CompanyDaoImpl();
            enterprise = companyDao.find(new Integer(id));
        }
        return new ModelAndView("form-company", "enterprise", enterprise);
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute("enterprise")Enterprise enterprise) throws SQLException{
        action(enterprise);
        return "redirect:../company/";
    }
    
    private void action(Enterprise enterprise) throws SQLException{
        CompanyDao companyDao = new CompanyDaoImpl();
        if (enterprise.getId()== 0){
            companyDao.add(enterprise);
        }else{
            companyDao.update(enterprise);
        }
        
    }
    
}
