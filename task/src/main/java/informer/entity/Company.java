/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author firsachi
 */
@Entity
@NamedQueries(
		{
			@NamedQuery(
					name = "allCompany", 
					query = "select C from Company C ORDER BY C.id"
					),
			@NamedQuery(
					name = "company", 
					query = "select C from Company C where C.disable = false ORDER BY C.name"
					),
			@NamedQuery(
					name = "uniqieNameCompany",
					query = "select C from Company C WHERE C.id <> :id AND  C.name = :nameCompany"
					),
			@NamedQuery(
					name = "deleteCompany", 
					query = "UPDATE Company C SET C.disable = true WHERE C.id = :id"
					)
		}
	)
@Table(name = "company", uniqueConstraints = { @UniqueConstraint(columnNames = "name")})
public class Company implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "delete")
    private boolean disable = false;

	@OneToMany(mappedBy = "enterprise", fetch = FetchType.EAGER)
    private List<Employee> employees;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "company_department",
			joinColumns = {	@JoinColumn(name = "department_id")},
			inverseJoinColumns = {@JoinColumn(name = "company_id")}
	)
	private Set<Department> departments;

    public Company() {
	}

	public Company(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", remove=" + disable + ", employees=" + employees
				+ ", departments=" + departments + "]";
	}

}
