/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.entity.Enterprise;

/**
 *
 * @author firsachi
 */
public interface CompanyDao {
    
    void add(Enterprise enterprise) throws SQLException;
    void delete(Enterprise enterprise) throws SQLException;
    void update(Enterprise enterprise) throws SQLException;
    Enterprise find(Integer id) throws SQLException;
    List<Enterprise> getList() throws SQLException;
    
}
