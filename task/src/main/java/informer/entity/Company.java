/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
					query = "select C from Company C where C.remove = false ORDER BY C.name"
					),
			@NamedQuery(
					name = "deleteCompany", 
					query = "UPDATE Company C SET C.remove = true WHERE C.id = :id"
					)
		}
	)
@Table(name = "company")
public class Company implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @Column(name = "delete")
    private boolean remove = false;

	@OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
    private List<Employee> employees;

	
    public Company() {
	}

	public Company(int id) {
		this.id = id;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    
    public boolean getRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (remove ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (remove != other.remove)
			return false;
		return true;
	}
	
}
