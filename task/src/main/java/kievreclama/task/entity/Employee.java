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
    
    @Column(name = "room")
    private int room;
    
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

    public void setRoom(int room) {
        this.room = room;
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

    public int getRoom() {
        return room;
    }
    
}
