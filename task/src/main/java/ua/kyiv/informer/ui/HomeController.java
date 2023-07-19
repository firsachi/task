package ua.kyiv.informer.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author firsov
 *
 */
@Controller
@RequestMapping(value = {"/home", "/home/"})
public class HomeController {

	@RequestMapping
	public String getHomePage() {
		return "home";
	}
}
