/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
			query = "SELECT E FROM Employee E WHERE E.remove = false ORDER BY E.id"),
	@NamedQuery (
			name = "deleteEmployee", 
			query = "UPDATE Employee E SET E.remove = true WHERE E.id=:id"),
	@NamedQuery (
			name = "selectIdDepartment", 
			query = "SELECT E FROM Employee E WHERE E.remove = false AND E.department.id = :departmentId")
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
    @ManyToOne
    private Phone phone;
    
    @JoinColumn(name = "post", referencedColumnName = "id")
    @ManyToOne
    private Position post;
    
    @JoinColumn(name = "department", referencedColumnName = "id")
    @ManyToOne
    private Department department;
    
    
    @JoinColumn(name = "enterprise", referencedColumnName = "id")
    @ManyToOne
    private Company enterprise;
    
    @Column(name = "email")
    private String email;
    
    @JoinColumn(name = "room", referencedColumnName = "id")
    @ManyToOne
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

	public Position getPost() {
		return post;
	}

	public void setPost(Position post) {
		this.post = post;
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
   
}
