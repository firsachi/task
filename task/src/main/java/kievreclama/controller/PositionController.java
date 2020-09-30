/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.controller;

import kievreclama.task.web.PositionService;
import kievreclama.task.web.models.PositionModel;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/position")
public class PositionController {
    
    private PositionModel positionModel;
    
    @Autowired
    private PositionService positionService;
    
    private final String[] HEFT_POST = {"1.0","1.1","2.0","2.1","3.0","3.1","4.0","4.1","5.0","5.1","6.0","6.1","7.0","7.1","8.0","8.1","9.0","9.1"};
    
    @ModelAttribute("allPositions")
    public List<PositionModel> allPost(){
    	return positionService.getList("allPositions");
    }
    
    @ModelAttribute("allHeft")
    public String[] getHeft() {
    	return HEFT_POST;
    }
     
    @ModelAttribute("position")
    public PositionModel positionAttribute() {
    	return positionModel;
    }
    
    @PostConstruct
    private void init() {
    	this.positionModel = new PositionModel();
    }
    
    @RequestMapping
    public String getPostPage(){
        return "position/position";
    }
    
    @GetMapping(value = "/add")
    public String getAddPage(){
        return "position/position-add";
    }
    
    @PostMapping(value = "/add", params = { "save" })
    public String submitAddPosition(@Valid @ModelAttribute("position") PositionModel model, final BindingResult bindingResult)  {
    	model.setId(0);
    	if (bindingResult.hasErrors()) {
			return "position/position-add";
		}
    	positionService.save(model);
    	positionModel = new PositionModel();
    	return "redirect:/position/";
    }
    
    @GetMapping(value = "/edit/{id}")
    public String getPagesFormCompany( @PathVariable int id, ModelMap model ){
    	model.addAttribute("position", positionService.getId(id));
        return "position/position-edit";
    }
    
    @PostMapping(value = "/edit/{id}", params = { "save" })
    public String submitUpadtePosition(@Valid @ModelAttribute("position") PositionModel model, final BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
			return "position/position-edit";
		}
    	positionService.update(model);
    	positionModel = new PositionModel();
    	return "redirect:/position/";
    }
    
    @GetMapping(value = "/delete/{id}")
    public String delete( @PathVariable Integer id ){
    	positionService.delete(id);
    	return "redirect:/position/";
    }
    
}
