package ua.kyiv.informer.ui.hr.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kyiv.informer.logic.service.HrOrderService;

@Controller
public class HrOrderController {

	@Autowired
	private HrOrderService hrOrderService;
	
	@RequestMapping(path = {"hr/", "/hr"})
	public String mainPageHrOrder() {
		hrOrderService.getHrOrderList();
		return "hr/HrOrder";
	}
}
