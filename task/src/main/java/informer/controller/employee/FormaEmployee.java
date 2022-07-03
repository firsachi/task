package informer.controller.employee;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import informer.model.DepartmentModel;
import informer.model.EmployeeModel;
import informer.model.PhoneModel;
import informer.model.PositionModel;
import informer.model.RoomModel;
import ua.kyiv.informer.logic.CompanyService;
import ua.kyiv.informer.logic.DepartmentService;
import ua.kyiv.informer.logic.PhoneService;
import ua.kyiv.informer.logic.PositionService;
import ua.kyiv.informer.logic.RoomServiceImpl;
import ua.kyiv.informer.ui.company.CompanyModel;

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
