/**
 * 
 */
package informer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author firsov
 *
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@RequestMapping
	public String getHomePage() {
		return "home";
	}
}
