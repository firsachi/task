package ua.kyiv.informer.logic.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
		@NamedQuery(name = "isUniqueName", query = "SELECT D FROM Department D WHERE D.id <> :id AND D.name = :name"),
		@NamedQuery(name = "searchDepartmentExists", query = "SELECT D FROM Department D WHERE D.name = :departmentName"),
		@NamedQuery(name = "department.disableFalse", query = "SELECT D FROM Department D WHERE D.disable = false ORDER BY D.name")
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Department that = (Department) o;
		return id == that.id && disable == that.disable && Objects.equals(name, that.name) && Objects.equals(companies, that.companies) && Objects.equals(employees, that.employees);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, companies, employees, disable);
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", companies=" + companies +
				", employees=" + employees +
				", disable=" + disable +
				'}';
	}
}
