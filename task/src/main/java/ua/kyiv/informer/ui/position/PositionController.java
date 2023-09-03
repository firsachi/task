package ua.kyiv.informer.ui.position;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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