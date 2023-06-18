/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.informer.ui.department;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;

import ua.kyiv.informer.rest.employee.EmployeeModel;

/**
 *
 * @author firsov
 */
public class ModelDepartment {

    private int id;
    private String name; 
    private String phone;
    private String fax;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    private List<EmployeeModel> employees;

    public int getId() {
        return id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

	public List<EmployeeModel> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "ModelDepartment [id=" + id + ", name=" + name + ", phone=" + phone + ", fax=" + fax + ", employees="
				+ employees + "]";
	}
    
}
