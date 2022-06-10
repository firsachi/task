/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.repository.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
 * @author firsov
 */
@Entity
@Table(name = "department", uniqueConstraints = { @UniqueConstraint(columnNames = "name")})
@NamedQueries({
	@NamedQuery(name = "allDepartments", query = "SELECT D FROM Department D ORDER BY D.name"),
	@NamedQuery(name = "department", query = "SELECT D FROM Department D WHERE D.disable = false ORDER BY D.name" ),
	@NamedQuery(name = "deleteDepartment", query = "UPDATE Department D SET D.disable = true WHERE D.id = :id"),
	@NamedQuery(name = "existsName", query = "SELECT D FROM Department D WHERE D.id <> :id AND D.name = :param"),
})
public class Department implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
	@Column(name = "name")
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "company_department",
			joinColumns = {	@JoinColumn(name = "company_id")},
			inverseJoinColumns = {@JoinColumn(name = "department_id")}
	)
    private List<Company> companies;
    
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    
    @Column(name = "disable", nullable = false, columnDefinition = "boolean default false")
    private boolean disable;

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

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companies, disable, employees, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(companies, other.companies) && disable == other.disable
				&& Objects.equals(employees, other.employees) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", companies=" + companies + ", employees=" + employees
				+ ", disable=" + disable + "]";
	}

}
