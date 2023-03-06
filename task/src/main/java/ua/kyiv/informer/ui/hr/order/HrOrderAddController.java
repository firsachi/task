package ua.kyiv.informer.ui.hr.order;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import informer.model.EmployeelLiteModel;
import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.logic.service.HrOrderService;

@Controller
public class HrOrderAddController extends BaseController<HrOrderService> {
	
	@Autowired
	private EmployeeService employeeService;
	
	private HrOrderModel hrOrderModel;
	
	@ModelAttribute(name = "hrOrderModel")
	public HrOrderModel getHrOrderModel() {
		return this.hrOrderModel;
	}
	
	@ModelAttribute(name ="employeeCollections")
	public Set<EmployeelLiteModel> getUserlist(){
		return employeeService.getEmployeeLite();
	}
	
	public HrOrderAddController() {
		super();
		this.hrOrderModel = new HrOrderModel();
	}

	@RequestMapping(path = {"/hr/add", "hr/add/"})
	public String pageAddHrOrder(ModelMap modelMap) {
		return "hr/HrOrder-add";
	}
	
}
