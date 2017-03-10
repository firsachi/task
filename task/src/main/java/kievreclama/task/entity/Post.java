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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((heft == null) ? 0 : heft.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Post other = (Post) obj;
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
