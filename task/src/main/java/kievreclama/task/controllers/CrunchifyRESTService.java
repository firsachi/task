/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.DepartmentDao;
import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.entity.Company;
import kievreclama.task.entity.Department;
import kievreclama.task.entity.Employee;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author firsov
 */
@Path("/")
public class CrunchifyRESTService {
    @GET
    @Path("/crunchifyService")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crunchifyREST(){
        StringBuilder crunchifyBuilder = new StringBuilder();
        CompanyDao companyDao = new CompanyDaoImpl();
        List<Company> list = null;
        try {
            list = companyDao.getList();
        } catch (SQLException ex) {
            Logger.getLogger(CrunchifyRESTService.class.getName()).log(Level.SEVERE, null, ex);
        }
            JSONObject resultJson = new JSONObject();
        try {
            crunchifyBuilder.append("[");
            int index = 0;
            int siseList = list.size() - 1;
            for (Company company: list){
                resultJson.put("name", company.getName());
                crunchifyBuilder.append(resultJson.toString());
                if (index != siseList--) {
                    crunchifyBuilder.append(",");
                }
            }
           crunchifyBuilder.append("]");
           // resultJson[1].put("name", companyDao.getList().get(1).getName());
        } catch (JSONException ex) {
            Logger.getLogger(CrunchifyRESTService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return Response.status(200).entity(crunchifyBuilder.toString()).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/loadDepartments")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listDepartments() throws SQLException {
            StringBuilder result = new StringBuilder();
            DepartmentDao departmentDao = new DepartmentDaoImpl();
            List<Department> departmentsList = departmentDao.list();
            JSONObject resultJson = new JSONObject();
            result.append("[");
            int index = 0;
            int siseList = departmentsList.size() - 1;
                for (Department department: departmentDao.list()){
                    try {
                        resultJson.put("idDepartment", department.getId());
                        resultJson.put("name", department.getName());
                        resultJson.put("phone", department.getPhone());
                        resultJson.put("fax", department.getFax());
                       // resultJson.put("listEmployees", resultString.toString());
                        result.append(resultJson.toString());
                        if (index != siseList--) {
                            result.append(",");
                        }
                    } catch (JSONException ex) {
                        Logger.getLogger(CrunchifyRESTService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            result.append("]");
            // return HTTP response 200 in case of success
            return Response.status(200).entity(result.toString()).header("Access-Control-Allow-Origin", "*").build();
	}
    
        @GET
	@Path("/loadEmployes/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listEmployees(@PathParam("id") Integer id ) throws SQLException {
            StringBuilder result = new StringBuilder();
            List<Employee> list = new EmployeeDaoImpl().getList(id);
            JSONObject resultJson = new JSONObject();
            result.append("[");
            int index = 0;
            int siseList = list.size() -1;
                for (Employee employee : list){
                    try {
                        resultJson.put("fullName", employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
                        resultJson.put("post", employee.getPost().getName());
                        resultJson.put("phone", employee.getPhone().getNumber());
                        resultJson.put("room", employee.getRoom().getNumberRoom());
                        resultJson.put("email", employee.getEmail());
                        resultJson.put("importance", employee.getPost().getHeft());
                        result.append(resultJson.toString());
                        if (index != siseList--) {
                            result.append(",");
                        }
                    } catch (JSONException ex) {
                        Logger.getLogger(CrunchifyRESTService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            result.append("]");
            // return HTTP response 200 in case of success
            return Response.status(200).entity(result.toString()).header("Access-Control-Allow-Origin", "*").build();
	}
}
