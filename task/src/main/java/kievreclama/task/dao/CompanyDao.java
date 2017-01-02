/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author firsachi
 * @param <T>
 */
public interface CompanyDao<T> {
    
    void add(T enterprise) throws SQLException;
    void delete(T enterprise) throws SQLException;
    void update(T enterprise) throws SQLException;
    T find(Integer id) throws SQLException;
    List<T> getList() throws SQLException;
    
}
