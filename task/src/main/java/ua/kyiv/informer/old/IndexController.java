/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.informer.old;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author firsov
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}

}
