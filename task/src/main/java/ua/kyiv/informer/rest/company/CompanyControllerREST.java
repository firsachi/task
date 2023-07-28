package ua.kyiv.informer.rest.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author firsov
 */
@RestController
@RequestMapping(value = "/api/", produces = "text/plain;charset=UTF-8")
public class CompanyControllerREST {

	private final ObjectMapper mapper;

	private final CompanyServiceREST service;

	@Autowired
	public CompanyControllerREST(ObjectMapper mapper, CompanyServiceREST service) {
		this.mapper = mapper;
		this.service = service;
	}

	@CrossOrigin
	@RequestMapping(path = {"/loadCompanies", "loadCompanies/"})
	public String listCompany() {
		try {
			return mapper.writeValueAsString(service.getListModel());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	@CrossOrigin
	@GetMapping(value = "findCompany/{id}")
	public String byCompany(@PathVariable int id) {
		try {
			return mapper.writeValueAsString(service.byCompany(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

}
