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
    private int number;
    
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

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
    
}
