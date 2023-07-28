package ua.kyiv.informer.rest.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api", produces = "text/plain;charset=UTF-8")
public class DepartmentControllerREST {

	private final ObjectMapper mapper;

	private final DepartmentServiceREST departmentServiceREST;

	@Autowired
	public DepartmentControllerREST(ObjectMapper mapper, DepartmentServiceREST departmentServiceREST) {
		this.mapper = mapper;
		this.departmentServiceREST = departmentServiceREST;
	}

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
	@GetMapping(value = "/findDepartment/{id}")
	public String byDepartmentId(@PathVariable int id) {
		try {
			return mapper.writeValueAsString(departmentServiceREST.byDepartment(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Error";
		}
	}
}
