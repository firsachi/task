package ua.kyiv.informer.logic.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author firsov
 */
@Entity
@Table(name = "room")
@NamedQueries({
	@NamedQuery ( name = "allRooms", query = "SELECT R FROM Room R WHERE R.numberRoom <> 0 ORDER BY R.numberRoom" ),
	@NamedQuery ( name = "findNumberRoom", query = "SELECT R FROM Room R WHERE R.numberRoom = :numberRoom")
})
public class Room implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "number_room", nullable = false, length = 3)
    private int numberRoom;
    
    @OneToMany(mappedBy = "room")
    private List<Employee> employees;

    
    public Room() {
	}

	public Room(int id) {
		this.id = id;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + id;
		result = prime * result + numberRoom;
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
		Room other = (Room) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id != other.id)
			return false;
		if (numberRoom != other.numberRoom)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", numberRoom=" + numberRoom + ", employees=" + employees + "]";
	}
    
}
