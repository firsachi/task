/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.informer.ui.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.service.PositionService;

/**
 *
 * @author firsov
 */
@Controller
public class PositionController extends CorePositionController {

    public PositionController() {
        super("position-table");
    }

    @PreAuthorize("hasAnyAuthority('position:read')")
    @RequestMapping
    public String getPostPage(Model model){
    	model.addAttribute("allPositions", positionService.getList("allPositions"));
        return getUrl();
    }

    
}
