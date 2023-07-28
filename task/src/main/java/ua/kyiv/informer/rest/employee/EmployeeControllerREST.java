package ua.kyiv.informer.rest.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import informer.rest.model.FilterParm;

@RestController
@RequestMapping(value = "/api", produces = "text/plain;charset=UTF-8")
public class EmployeeControllerREST {

	private final EmployeeServiceREST service;

	private final ObjectMapper mapper;

	@Autowired
	public EmployeeControllerREST(EmployeeServiceREST service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@CrossOrigin
	@PreAuthorize("!isAuthenticated()")
	@GetMapping(path = {"/loadEmployes/{companyId}/{departmentId}", "loadEmployes/{companyId}/{departmentId}/"})
	public String listEmployees(@PathVariable("companyId") int companyId, @PathVariable("departmentId") int departmentId) {
		try {
			return mapper.writeValueAsString(service.getListEmployeeDepartment(new FilterParm(companyId, departmentId)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "eroor";
		}
	}
	
}
