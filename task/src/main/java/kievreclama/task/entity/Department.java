/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author firsov
 */
@Entity
@Table(name = "department")
@NamedQueries({
	@NamedQuery(name = "allDepartments", query = "FROM Department D ORDER BY D.id"),
	@NamedQuery(name = "department", query = "FROM Department D WHERE D.remove = false ORDER BY D.name" ),
	@NamedQuery(name = "deleteDepartment", query = "UPDATE Department D SET D.remove = true WHERE D.id = :id")
})
public class Department implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "phone") 
    private String phone;
    
    @Basic(optional = false)
    @Column(name = "fax")
    private String fax;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    
    @Column(name = "delete")
    private boolean remove = false;

    public Department() {
	}

	public Department(int id) {
		this.id = id;
	}

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

    public void setRemove(boolean delete) {
        this.remove = delete;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public boolean getRemove() {
        return remove;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    
    
}
