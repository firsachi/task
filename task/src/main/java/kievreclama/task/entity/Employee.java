/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author firsov
 */
@Entity
@Table(name = "emplouers")
public class Employee implements Cloneable, Serializable{
    
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
    
    @ManyToOne
    @JoinColumn(name = "phone")
    private Phone phone;
    
    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;
    
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
    
    @ManyToOne
    @JoinColumn (name = "enterprise")
    private Enterprise enterprise;
    
    @Column(name = "email")
    private String email;
    
    @ManyToOne
    @JoinColumn (name = "room")
    private Room room;
    
    @Column(name = "login", unique = true)
    private String login;
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Phone getPhone() {
        return phone;
    }

    public Post getPost() {
        return post;
    }

    public Department getDepartment() {
        return department;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public String getEmail() {
        return email;
    }

    public Room getRoom() {
        return room;
    }

    public String getLogin() {
        return login;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    
}
