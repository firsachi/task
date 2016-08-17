/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.entity;

/**
 *
 * @author firsachi
 */
public interface SqlQuery {
    
    public static final String ALL_TASK = 
            "SELECT tasks.id,emplouers.surname,emplouers.name,emplouers.patronymic," + 
            "task,number,date_create,urgency,state,delete FROM tasks " +
            "JOIN users ON users.id=tasks.emploue " +
            "JOIN emplouers ON emplouers.login=users.id "+ 
            "WHERE delete=false ";
    public static final String ALL_USER_TASK = ALL_TASK + " AND emploue=?";
    public static final String ALL_EMPLOUERS = "SELECT * FROM emplouers";
    public static final String ALL_URGENCY = "SELECT * FROM type_urgency";
    
}
