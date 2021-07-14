package informer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import informer.rest.model.DepartmentModel;

@RestController
@RequestMapping(value = "/api", produces = "text/plain;charset=UTF-8")
public class EmployeeControllerREST {
	
	@Autowired
	private EmployeeServiceREST service;
	
	@Autowired
	private ObjectMapper mapper;
	
	@CrossOrigin
	@PostMapping(value = "/loadEmployes/")
	public String listEmployees(@ModelAttribute DepartmentModel department) {
		try {
			return mapper.writeValueAsString(service.getListEmployeeDepartment(department.getId()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "eroor";
		}
	}
}
