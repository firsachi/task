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

import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.PositionModel;
import informer.service.PositionService;

/**
 *
 * @author firsov
 */
@Controller
@RequestMapping(value = "/position")
public class PositionController {
	
	private boolean deletePosition = false;
	
    @Autowired
    private PositionService positionService;
    
    @ModelAttribute("allPositions")
    public List<PositionModel> allPost(){
    	return positionService.getList("allPositions");
    }
    
    @ModelAttribute("deletePosition")
    public boolean deletePosition() {
    	return deletePosition;
    }
    
    @RequestMapping
    public String getPostPage(){
    	deletePosition = false;
        return "position/position";
    }
    /*

    */
    @GetMapping(value = "/delete/{id}")
    public String delete( @PathVariable Integer id, final ModelMap model ){
    	if (positionService.delete(id)) {
    		return "redirect:/position/";
    	}
    	deletePosition = true;
    	return "redirect:/position/";
    }
    
}
