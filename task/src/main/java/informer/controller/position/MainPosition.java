/**
 * 
 */
package informer.controller.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.PositionService;

/**
 * @author firsov
 *
 */
@RequestMapping(path = { "/position", "position/" })
public abstract class MainPosition {

	private final String[] HEFT_POST = { "1.0", "1.1", "2.0", "2.1", "3.0", "3.1", "4.0", "4.1", "5.0", "5.1", "6.0",
			"6.1", "7.0", "7.1", "8.0", "8.1", "9.0", "9.1" };

	@Autowired
	protected PositionService positionService;

	@ModelAttribute("allHeft")
	public String[] getHeft() {
		return HEFT_POST;
	}

}
