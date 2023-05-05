package ua.kyiv.informer.ui.hr.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import informer.model.EmployeelLiteModel;
import ua.kyiv.informer.logic.service.EmployeeService;
import ua.kyiv.informer.logic.service.HrOrderService;

@Controller
public class HrOrderAddController extends BaseController<HrOrderService> {
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private EmployeeService employeeService;
	
	public HrOrderAddController() {
		super();
	}

	@RequestMapping(path = {"/hr/add", "hr/add/"})
	public String pageAddHrOrder(ModelMap modelMap, HrOrderModel hrOrderModel) {
		modelMap.addAttribute("hrOrderModel", hrOrderModel);
		modelMap.addAttribute("employee", new EmployeelLiteModel());
		return "hr/HrOrder-add";
	}
	
	@GetMapping(path = {"/hr/forme-mployee", "hr/form-employee"})
	public String formAddEmployee(ModelMap modelMap) {
		modelMap.addAttribute("employeeCollections", employeeService.getEmployeeLite());
		modelMap.addAttribute("employee", new EmployeelLiteModel());
		return "hr/hr-order-fragment :: modalAddEmployee";
	}
	
	@PostMapping(path = {"/hr/newrow", "hr/newrow/"})
	public String pageNewRowTable(@ModelAttribute("employee") EmployeelLiteModel employeelLiteModel) {
		employeelLiteModel = employeeService.byLiteModel(employeelLiteModel.getId());
		return "hr/hr-order-fragment :: rowtable(fullName='"+ employeelLiteModel.getFullName() +"', departmentName='')";
	}
	
}
