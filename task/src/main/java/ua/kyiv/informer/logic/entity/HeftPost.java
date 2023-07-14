package ua.kyiv.informer.logic.entity;

import jakarta.persistence.*;

import java.io.Serializable;

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
