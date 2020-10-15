/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author firsachi
 */
@Entity
@Table(name = "heft")
public class HeftPost implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "heft", unique = false, nullable = false)
    private String heft;

    public void setId(int id) {
        this.id = id;
    }

    public void setHeft(String heft) {
        this.heft = heft;
    }

    public int getId() {
        return id;
    }

    public String getHeft() {
        return heft;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heft == null) ? 0 : heft.hashCode());
		result = prime * result + id;
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
		HeftPost other = (HeftPost) obj;
		if (heft == null) {
			if (other.heft != null)
				return false;
		} else if (!heft.equals(other.heft))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
    
    
}
