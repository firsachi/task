/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.informer.repository.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author firsov
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "allPositions", query = "SELECT P FROM Position P ORDER BY P.disable"),
	@NamedQuery(name = "posts", query = "SELECT P FROM Position P WHERE P.disable = false ORDER BY P.namePosition"),
	@NamedQuery(name = "deletePost", query = "UPDATE Position P SET P.disable = true WHERE P.id = :id")
	})
public class Position implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "name", unique = true, nullable = false)
    private String namePosition;
    
    @Column(name = "heft", nullable = false)
    private String heft;
    
    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;
    
    @Column
    private boolean disable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

	public String getHeft() {
		return heft;
	}

	public void setHeft(String heft) {
		this.heft = heft;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + (disable ? 1231 : 1237);
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((heft == null) ? 0 : heft.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((namePosition == null) ? 0 : namePosition.hashCode());
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
		Position other = (Position) obj;
		if (disable != other.disable)
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (heft == null) {
			if (other.heft != null)
				return false;
		} else if (!heft.equals(other.heft))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (namePosition == null) {
			if (other.namePosition != null)
				return false;
		} else if (!namePosition.equals(other.namePosition))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", namePosition=" + namePosition + ", heft=" + heft + ", employees=" + employees
				+ ", disable=" + disable + "]";
	}

}
