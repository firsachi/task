/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.controller.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.PositionModel;
import ua.kyiv.informer.logic.service.PositionService;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(path = {"/position", "position/"})
public class PositionController {
	
    @Autowired
    private PositionService positionService;
    
    @ModelAttribute("allPositions")
    public List<PositionModel> allPost(){
    	return positionService.getList("allPositions");
    }
    
    @RequestMapping
    public String getPostPage(){
        return "position/position";
    }
    
    @GetMapping(value = "/selectedPosition/{id}")
    public String selectedPosition( @PathVariable Integer id, final ModelMap model ){
    	model.addAttribute("position", positionService.getId(id));
    	return "fragments/position-fargment :: deleteModalWindow";
    }
    
    @PostMapping(path = {"/delete", "delete/", "/delete/"})
    public String deletePosition(@ModelAttribute("position") PositionModel model) {
    	positionService.delete(model.getId());
    	return "redirect:/position/";
    }
    
}
