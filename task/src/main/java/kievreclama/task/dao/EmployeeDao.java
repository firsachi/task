/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.entity.Employee;

/**
 *
 * @author firsov
 */
public interface EmployeeDao {
    
    Employee find(Employee employee) throws SQLException;
    List<Employee> getList() throws SQLException;
}
