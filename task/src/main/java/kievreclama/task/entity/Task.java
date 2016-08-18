/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author firsov
 */
@Entity
@Table(name="tasks")
public class Task implements Serializable {
    
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "emploue")
    private Employee emploue;
    
    @Column(name = "task")
    private String infoTask;
    
    @Column(name = "urgency")
    private String priority;
    
    @Column(name = "number")
    private String number;
    
    @Column(name = "date_create")
    private String date;
    
    @Column(name = "state")
    private boolean statys;
    
    @Column(name = "delete")
    private boolean delete;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmploue(Employee emploue) {
        this.emploue = emploue;
    }

    public void setInfoTask(String infoTask) {
        this.infoTask = infoTask;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatys(boolean statys) {
        this.statys = statys;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public Employee getEmploue() {
        return emploue;
    }

    public String getInfoTask() {
        return infoTask;
    }

    public int getPriority() {
        return new Integer(priority);
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public boolean isStatys() {
        return statys;
    }

    public boolean isDelete() {
        return delete;
    }
    
    
}
