package informer.controller.employee;

import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.kyiv.informer.logic.service.CompanyService;
import ua.kyiv.informer.logic.service.DepartmentService;
import ua.kyiv.informer.logic.service.PhoneService;
import ua.kyiv.informer.logic.service.PositionService;
import ua.kyiv.informer.logic.service.RoomServiceImpl;
import ua.kyiv.informer.rest.PhoneModel;
import ua.kyiv.informer.rest.RoomModel;
import ua.kyiv.informer.rest.department.DepartmentModel;
import ua.kyiv.informer.rest.employee.EmployeeModel;
import ua.kyiv.informer.ui.company.CompanyModel;
import ua.kyiv.informer.ui.position.PositionModel;

public abstract class FormaEmployee {
	
	protected EmployeeModel employee;
	
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private PositionService postService;
    
    @Autowired
    private RoomServiceImpl roomService;
    
    @Autowired
    private PhoneService phoneService;
    
    @ModelAttribute("allCompany")
    public List<CompanyModel> allCompany(){
    	return companyService.all("company");
    }
    
    @ModelAttribute("allDepartment")
    public List<DepartmentModel> allDepartment() {
    	return departmentService.getList("department");
    }
    
    @ModelAttribute("allPost")
    public List<PositionModel> allPost() {
    	return postService.getList("posts");
    }
    
    @ModelAttribute("allRoom")
    public List<RoomModel> allRoom(){
    	return roomService.all("allRooms");
    }
    
    @ModelAttribute("allPhone")
    public List<PhoneModel> allPhone() {
    	return phoneService.getAll("allPhone");
    }
    
    @ModelAttribute("employee")
    private EmployeeModel employee() {
    	return employee;
    }
    
    @PostConstruct
    private void init() {
    	this.employee = new EmployeeModel();
    }

}
