/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author firsov
 */
public class Connctors {
    
    private static DataSource dataSource;
    private static Connctors connctors;

    private Connctors() {
        InitialContext cxt;
        try {
            cxt = new InitialContext();
            dataSource = (DataSource) cxt.lookup("java:comp/env/jdbc/postgres");
        } catch (NamingException ex) {
            Logger.getLogger(PostgresqlTaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() throws SQLException{
        if (null==connctors){
            connctors = new Connctors();
        }
        return dataSource.getConnection();
    }
}
