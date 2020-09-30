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
	@NamedQuery(name = "posts", query = "SELECT P FROM Position P WHERE P.disable = false ORDER BY P.name"),
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
    private String name;
    
    @Column(name = "heft", unique = true, nullable = false)
    private String heft;
    
    @OneToMany(mappedBy = "post")
    private Set<Employee> employees;
    
    @Column
    private boolean disable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	

}
