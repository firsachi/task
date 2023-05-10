package ua.kyiv.informer.rest.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api", produces = "text/plain;charset=UTF-8")
public class DepartmentControllerREST {
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private DepartmentServiceREST departmentServiceREST;
	
	@CrossOrigin
	@RequestMapping(value = "loadDepartments")
	public String listDepartments() {
		try {
			return mapper.writeValueAsString(departmentServiceREST.getListDepartments());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

	@CrossOrigin
	@PostMapping(value = "/department/{id}")
	public String byDepartmentId(@PathVariable int id) {
		try {
			return mapper.writeValueAsString(departmentServiceREST.byDepartment(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Eroor";
		}
		
	}
}
