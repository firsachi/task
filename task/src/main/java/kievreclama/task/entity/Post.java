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

/**
 *
 * @author firsov
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "allPosts", query = "FROM Post P ORDER BY P.id"),
	@NamedQuery(name = "posts", query = "FROM Post P WHERE P.remove = false ORDER BY P.name"),
	@NamedQuery(name = "deletePost", query = "UPDATE Post P SET P.remove = true WHERE P.id = :id")
	})
public class Post implements Serializable {
    
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
    
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Set<Employee> employees;
    
    @Column(name = "delete")
    private boolean remove;

    public Post() {
	}

	public Post(Integer id) {
		this.id = id;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeft(String heft) {
        this.heft = heft;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public boolean getRemove() {
		return remove;
	}
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeft() {
        return heft;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

	public void setRemove(boolean remove) {
		this.remove = remove;
	}
    
    
    
}
