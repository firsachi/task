/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value = "form/")
    public String getPagesFormCompany(Model model, @RequestParam(name = "id") String id) throws SQLException{
        CompanyDao companyDao = new CompanyDaoImpl();
        model.addAttribute("enterprise", companyDao.find(new Integer(id)));
        return "form-company";
    }
}
