/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.controllers.models;

/**
 *
 * @author firsov
 */
public class ModelEmployee {

    private int id;

    private String surname;

    private String name;

    private String patronymic;

    private Integer phone;

    private Integer post;

    private Integer department;

    private Integer enterprise;

    private String email;

    private Integer room;

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

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public void setEnterprise(Integer enterprise) {
        this.enterprise = enterprise;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoom(Integer room) {
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

    public Integer getPhone() {
        return phone;
    }

    public Integer getPost() {
        return post;
    }

    public Integer getDepartment() {
        return department;
    }

    public Integer getEnterprise() {
        return enterprise;
    }

    public String getEmail() {
        return email;
    }

    public Integer getRoom() {
        return room;
    }
    
    
}
