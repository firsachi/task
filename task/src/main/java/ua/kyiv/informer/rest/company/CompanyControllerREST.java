/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.informer.rest.company;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private CompanyServiceREST service;

	@CrossOrigin
	@RequestMapping(value = "crunchifyService")
	public String listCompany() {
		try {
			return mapper.writeValueAsString(service.getListModel());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	@CrossOrigin
	@GetMapping(value = "crunchifyService/{id}")
	public String byCompany(@PathVariable int id) {
		try {
			return mapper.writeValueAsString(service.byCompany(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

}
