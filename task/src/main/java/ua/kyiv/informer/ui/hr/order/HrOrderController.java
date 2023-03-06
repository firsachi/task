package ua.kyiv.informer.ui.hr.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.service.HrOrderService;

@Controller
@RequestMapping(path = {"hr/", "/hr"})
public class HrOrderController {

	@Autowired
	private HrOrderService hrOrderService;
	
	@RequestMapping
	public String mainPageHrOrder(ModelMap modelMap) {
		modelMap.addAttribute("hrOrderModelList", hrOrderService.getHrOrderList());
		return "hr/HrOrder";
	}
	
	
}
