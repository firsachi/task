/**
 * 
 */
package informer.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kyiv.ui.model.UserModel;

/**
 * @author firsachi
 *
 */
@Controller
public class LoginLogoutController {

	@Value("${error.message}")
	private String errorMessage;
	
	@RequestMapping(value = "/login")
    public String getLoginForm( @RequestParam(value = "error", required = false) String error, Model model) {
    	model.addAttribute("user", new UserModel());
    	if(error != null){
			model.addAttribute("errorMessage", errorMessage);
		}
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    	return "redirect:/informer";
    }
    
}
