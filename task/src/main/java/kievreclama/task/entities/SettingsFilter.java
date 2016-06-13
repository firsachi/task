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
public class SettingsFilter {
    
    private int custumer;
    private int priority;
    private boolean statys;
    
    public void setCustumer(String custumer) {
        this.custumer = new Integer(custumer);
    }

    public void setPriority(String priority) {
        this.priority = new Integer(priority);
    }

    public void setStatys(boolean statys) {
        this.statys = statys;
    }

    public int getCustumer() {
        return custumer;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isStatys() {
        return statys;
    }
    
}
