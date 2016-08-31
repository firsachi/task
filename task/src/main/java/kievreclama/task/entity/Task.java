/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "tasks")
public class Task implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
     
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id" , referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Employee employee;
    
    @Column(name = "task")
    private String task;
    
    @Column(name = "number")
    private String number;
    
    @Column(name = "date_create")
    private String date;
    
    @Column(name = "urgency")
    private Integer urgensy;
    
    @Column(name = "state")
    private Boolean state;
    
    @Column(name = "delete")
    private Boolean delete;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUrgensy(Integer urgensy) {
        this.urgensy = urgensy;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getTask() {
        return task;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public Integer getUrgensy() {
        return urgensy;
    }

    public Boolean getState() {
        return state;
    }

    public Boolean getDelete() {
        return delete;
    }
    
}
