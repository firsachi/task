package kievreclama.controller.emploees;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import kievreclama.task.web.CompanyService;
import kievreclama.task.web.DepartmentService;
import kievreclama.task.web.PhoneService;
import kievreclama.task.web.PositionService;
import kievreclama.task.web.RoomService;
import kievreclama.task.web.models.CompanyModel;
import kievreclama.task.web.models.DepartmentModel;
import kievreclama.task.web.models.EmployeeModel;
import kievreclama.task.web.models.PhoneModel;
import kievreclama.task.web.models.PositionModel;
import kievreclama.task.web.models.RoomModel;

public abstract class FormaEmployee {
	
	protected EmployeeModel employee;
	
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private PositionService postService;
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private PhoneService phoneService;
    
    @ModelAttribute("allCompany")
    public List<CompanyModel> allCompany(){
    	return companyService.getList("company");
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
    	return roomService.allRoom("allRooms");
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
