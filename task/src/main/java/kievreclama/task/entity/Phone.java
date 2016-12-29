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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author firsachi
 */
@Entity
@Table(name = "phone")
public class Phone implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "number", unique = true)
    private Integer number;
    
    @OneToMany(mappedBy = "phone", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
    
}
