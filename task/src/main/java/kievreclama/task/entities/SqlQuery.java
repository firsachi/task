/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entities;

/**
 *
 * @author firsachi
 */
public interface SqlQuery {
    
    public static final String ALL_TASK = 
            "SELECT tasks.id,users.login,task,number,date_create,urgency,state,delete " +
            "FROM tasks JOIN users ON users.id = tasks.emploue " +
            "WHERE delete=false " +
            "AND state=false " +
            "ORDER BY urgency";
    
}
