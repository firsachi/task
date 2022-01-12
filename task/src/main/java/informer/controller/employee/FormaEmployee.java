package informer.controller.employee;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import informer.model.CompanyModel;
import informer.model.DepartmentModel;
import informer.model.EmployeeModel;
import informer.model.PhoneModel;
import informer.model.PositionModel;
import informer.model.RoomModel;
import informer.service.DepartmentService;
import informer.service.PhoneService;
import informer.service.PositionService;
import informer.service.RoomServiceImpl;
import informer.service.CompanyService;

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
