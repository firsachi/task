package ua.kyiv.informer.ui;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author firsachi
 *
 */
@Controller
public class LoginLogoutController {
	
	@RequestMapping(value = "/login")
    public String getLoginForm() {
        return "login";
    }
    
    @GetMapping(path = {"/logout", "/logout/"})
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    	return "redirect:/informer";
    }
    
}
