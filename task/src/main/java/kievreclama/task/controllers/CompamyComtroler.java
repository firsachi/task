/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.controllers.models.ModelCompany;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.entity.Company;
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
@RequestMapping(value = "/private/company/")
public class CompamyComtroler {
    
    private final int IS_NEW = 0;
    private CompanyDao companyDao = new CompanyDaoImpl();
    
    @RequestMapping(value = "/")
    public String getPagesCompany(Model model) throws SQLException{
        model.addAttribute("company", companyDao.getList());
        return "company";
    }
    
    @RequestMapping(value = "/add")
    public ModelAndView getPagesFormAdd(){
        ModelAndView model = new ModelAndView("form-company-add", "enterprise", new ModelCompany());
        return model;
    }
    
    @GetMapping(value = "/edit{id}")
    public ModelAndView getPagesFormCompany( @PathVariable Integer id ) throws SQLException{
        ModelCompany modelEnterprise = new ModelCompany();
        if (!id.equals(IS_NEW)){
            modelEnterprise = fillModel(companyDao.find(id));
        }
        return new ModelAndView("form-company-edit", "enterprise", modelEnterprise);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("enterprise") ModelCompany modelCompany ) throws SQLException{
        action(modelCompany);
        return "redirect:../company/";
    }
    
    private ModelCompany fillModel(Company enterprise){
        ModelCompany model = new ModelCompany();
        model.setId(enterprise.getId());
        model.setName(enterprise.getName());
        return model;
    }
    
    private void action(ModelCompany modelCompany) throws SQLException{
        Company company = new Company();
        company.setId(modelCompany.getId());
        company.setName(modelCompany.getName());
        if (modelCompany.getId() == IS_NEW ){
            companyDao.add(company);
        }else{
            companyDao.update(company);
        }
    }
}
