/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.informer.rest.department;

import java.util.List;
import java.util.Objects;

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

    private boolean disable;

    private List<EmployeeModel> employees;

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

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelDepartment that = (ModelDepartment) o;
        return id == that.id && disable == that.disable && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(fax, that.fax) && Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, fax, disable, employees);
    }

    @Override
    public String toString() {
        return "ModelDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", disable=" + disable +
                ", employees=" + employees +
                '}';
    }
}
