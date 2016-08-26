/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.entity.Department;

/**
 *
 * @author firsov
 */
public interface DepartmentDao {
    
    void add(Department department) throws SQLException;
    void delete(Department department) throws SQLException;
    void update(Department department) throws SQLException;
    Department find(Integer id) throws SQLException;
    List<Department> list() throws SQLException;
}
