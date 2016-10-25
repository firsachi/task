/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    
    @JoinColumn(name = "phone", referencedColumnName = "id")
    @ManyToOne
    private Phone phone;
    
    @JoinColumn(name = "post", referencedColumnName = "id")
    @ManyToOne
    private Post post;
    
    @ElementCollection(fetch = FetchType.EAGER)
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
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();

    @Column (name = "remove", columnDefinition = "boolean default false", nullable = false)
    private Boolean remove = false;
    
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

    public void setEnterprise(Company enterprise) {
        this.enterprise = enterprise;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
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
    
    public String getFullName(){
        return surname + " " + name + " " + patronymic;
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

    public Company getEnterprise() {
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

    public Boolean getRemove() {
        return remove;
    }
    
}
