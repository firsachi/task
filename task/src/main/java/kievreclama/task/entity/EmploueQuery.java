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
public interface EmploueQuery {
    
    public static final String FIND_EMPLOUE = "SELECT users.id,surname,name,patronymic " +
            "FROM emplouers JOIN users ON users.id=emplouers.login " +
            "WHERE users.login = ?";
    
}
