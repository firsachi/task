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
import kievreclama.task.entity.Urgency;

/**
 *
 * @author firsov
 */
public class PostgresqlUrgencyDao {
    
    public ArrayList<Urgency> allUrgency(){
        ArrayList<Urgency> arrayUrgensy = new ArrayList<>();
        String sql = "SELECT * FROM type_urgency";
        try (Connection connection = Connctors.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                arrayUrgensy.add(createUrgensy(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlUrgencyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayUrgensy;
    }

    private Urgency createUrgensy(ResultSet rs) throws SQLException {
        Urgency urgensy = new Urgency();
        urgensy.setId(rs.getInt(1));
        return urgensy;
    }
}
