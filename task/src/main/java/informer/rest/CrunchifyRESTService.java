/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import informer.entity.Company;
import informer.entity.Employee;
import informer.repository.CompanyDaoImpl;
import informer.repository.EmployeeDaoImpl;

/**
 *
 * @author firsov
 */
@RestController
@RequestMapping(value = "/api/", produces = "text/plain;charset=UTF-8")
public class CrunchifyRESTService {

	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private EmployeeDaoImpl employeeDao;

	@CrossOrigin
	@RequestMapping(value = "crunchifyService")
	public String listCompany() {
		StringBuilder crunchifyBuilder = new StringBuilder();
		JSONArray array = new JSONArray();
		try {
			for (Company company : companyDao.byList("company")) {
				JSONObject resultJson = new JSONObject();
				resultJson.put("name", company.getName());
				crunchifyBuilder.append(resultJson.toString());
				array.put(resultJson);
			}
		} catch (JSONException ex) {
			Logger.getLogger(CrunchifyRESTService.class.getName()).log(Level.SEVERE, null, ex);
		}
		return array.toString();
	}


	
}
