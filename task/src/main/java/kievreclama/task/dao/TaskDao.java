/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.entity.Task;

/**
 *
 * @author firsov
 */
public interface TaskDao {
    
    void add(Task task) throws SQLException;
    void update(Task task) throws SQLException;
    Task findId(int id) throws SQLException;
    List<Task> list() throws SQLException;
    List<Task> list(int employeeId) throws SQLException;
    
}
