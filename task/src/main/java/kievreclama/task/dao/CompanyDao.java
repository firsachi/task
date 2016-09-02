/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.entity.Company;

/**
 *
 * @author firsachi
 */
public interface CompanyDao {
    
    void add(Company enterprise) throws SQLException;
    void delete(Company enterprise) throws SQLException;
    void update(Company enterprise) throws SQLException;
    Company find(Integer id) throws SQLException;
    List<Company> getList() throws SQLException;
    
}
