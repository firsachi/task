/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author firsov
 */
@Entity
@Table(name = "emplouers")
@NamedQueries({
	@NamedQuery (
			name = "allEmployee", 
			query = "SELECT E FROM Employee E ORDER BY E.remove"),
	@NamedQuery (
			name = "employees", 
			query = "SELECT E FROM Employee E ORDER BY E.id"),
	@NamedQuery (
			name = "deleteEmployee", 
			query = "UPDATE Employee E SET E.remove = true WHERE E.id=:id"),
	@NamedQuery (
			name = "selectIdDepartment", 
			query = "SELECT E FROM Employee E WHERE E.remove = false AND E.department.id = :departmentId ORDER BY E.position.heft")
})
public class Employee implements Cloneable, Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "patronymic")
    private String patronymic;
    
    @JoinColumn(name = "phone", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Phone phone;
    
    @JoinColumn(name = "post", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Position position;
    
    @JoinColumn(name = "department", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;
    
    
    @JoinColumn(name = "enterprise", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company enterprise;
    
    @Column(name = "email")
    private String email;
    
    @JoinColumn(name = "room", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
    
    @Column(name = "login", unique = true)
    private String login;
    
    @Column(name = "pass", nullable = false)
    private String pass;

    @Column (name = "remove", columnDefinition = "boolean default false", nullable = false)
    private Boolean remove = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Company getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Company enterprise) {
		this.enterprise = enterprise;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getRemove() {
		return remove;
	}

	public void setRemove(Boolean remove) {
		this.remove = remove;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enterprise == null) ? 0 : enterprise.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((remove == null) ? 0 : remove.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Employee other = (Employee) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enterprise == null) {
			if (other.enterprise != null)
				return false;
		} else if (!enterprise.equals(other.enterprise))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (patronymic == null) {
			if (other.patronymic != null)
				return false;
		} else if (!patronymic.equals(other.patronymic))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (remove == null) {
			if (other.remove != null)
				return false;
		} else if (!remove.equals(other.remove))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic
				+ ", phone=" + phone + ", position=" + position + ", department=" + department + ", enterprise="
				+ enterprise + ", email=" + email + ", room=" + room + ", login=" + login + ", pass=" + pass
				+ ", remove=" + remove + "]";
	}
}
