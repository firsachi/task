/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kievreclama.task.entity.Employee;
import kievreclama.task.entity.EmploueQuery;

/**
 *
 * @author firsov
 */
public class PostgresqlEmploueDao {
    
    public ArrayList<Employee> allEpmloue(){
        ArrayList<Employee> arrayEmploue = new ArrayList<>();
        String sql = "SELECT * FROM emplouers";
        try (Connection connction = Connctors.getConnection();
                PreparedStatement ps = connction.prepareStatement(sql);
            ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                arrayEmploue.add(createEmploue(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlEmploueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayEmploue;
    }
    
    public Employee findEmploue(String login){
        try (Connection connection = Connctors.getConnection();
                PreparedStatement ps = connection.prepareStatement(EmploueQuery.FIND_EMPLOUE);) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return createEmploue(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlEmploueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Employee createEmploue(ResultSet rs) throws SQLException {
        Employee emplouer = new Employee();
        emplouer.setId(rs.getInt(1));
        emplouer.setSurname(rs.getString(2));
        emplouer.setName(rs.getString(3));
        emplouer.setPatronymic(rs.getString(4));
       //emplouer.setLogin(rs.getString(2));
        return emplouer;
    }
    
}
