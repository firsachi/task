/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entities;

/**
 *
 * @author firsov
 */
public class Task {
    private int id;
    private Emploue emploue;
    private String infoTask;
    private String priority;
    private String number;
    private String date;
    private boolean statys;
    private boolean delete;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmploue(Emploue emploue) {
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

    public Emploue getEmploue() {
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
