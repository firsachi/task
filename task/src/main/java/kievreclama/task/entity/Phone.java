/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import java.util.Set;
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
@Table(name = "phone")
@NamedQueries({
	@NamedQuery ( name = "allPhone", query = "FROM Phone P ORDER BY P.id")
})
public class Phone implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "number", unique = true)
    private String number;
    
    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Phone() {
	}

	public Phone(int id) {
		this.id = id;
	}



	public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + id;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Phone other = (Phone) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id != other.id)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", employees=" + employees + "]";
	}
	
    
}
