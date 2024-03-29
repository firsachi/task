package ua.kyiv.informer.logic.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author firsachi
 */
@Entity
@Table(name = "phone")
@NamedQueries({
	@NamedQuery ( name = "allPhone", query = "SELECT P FROM Phone P WHERE P.phoneNumber <> '0' ORDER BY P.id"),
		@NamedQuery( name = "phone.checkUniqueNumber", query = "SELECT P FROM Phone P WHERE P.phoneNumber = :phoneNumber")
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
    private String phoneNumber;
    
    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Phone() {
	}
    
	public Phone(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + id;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", phoneNumber=" + phoneNumber + ", employees=" + employees + "]";
	}
    
}
