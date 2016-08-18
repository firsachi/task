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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import kievreclama.task.entity.Employee;
import kievreclama.task.entity.SqlQuery;
import kievreclama.task.entity.Task;

/**
 *
 * @author firsov
 */
public class PostgresqlTaskDao {
    
    public  ArrayList<Task> fillTables(String sql){
        System.out.println(sql);
        ArrayList<Task> arrayTask = new ArrayList<>();
        try (   Connection connection = Connctors.getConnection();
                PreparedStatement ps = connection.prepareCall(sql);) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                arrayTask.add(initTask(rs, new Employee()));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlTaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayTask;
    }
    
    public ArrayList<Task> fillEmpluertTask(Employee emploue){
        ArrayList<Task> arrayEmplouerTask = new ArrayList<>();
        try (
                Connection connection = Connctors.getConnection();
                PreparedStatement ps = connection.prepareStatement(SqlQuery.ALL_USER_TASK);
            ){
            ps.setInt(1, emploue.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                arrayEmplouerTask.add(initTask(rs, emploue));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlTaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayEmplouerTask;
    }
    
    public Task add(Task task) {
        String sql ="INSERT INTO tasks (emploue,task,number,urgency) VALUES (?,?,?,?)";
        try (Connection connection = Connctors.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ) {
            ps.setInt(1, task.getEmploue().getId());
            ps.setString(2, task.getInfoTask());
            ps.setString(3, task.getNumber());
            ps.setInt(4, new Integer(task.getPriority()));
            ps.executeUpdate();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet resultSet = ps.getGeneratedKeys();
             if (resultSet.next() ){
                task.setId(resultSet.getInt(1));
                task.setDate(format1.format(new Date()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlTaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return task;
    }
    
    public Task getTask(int id){
        String sql = "SELECT * FROM tasks WHERE id=?";
        try (Connection connection = Connctors.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return initTask(rs, new Employee());
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlTaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean updateTask(Task task){
        String sql="UPDATE tasks SET urgency=?,task=?,number=?,state=? WHERE id=?";
        try (Connection connection = Connctors.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            ps.setInt(1, task.getPriority());
            ps.setString(2, task.getInfoTask());
            ps.setString(3, task.getNumber());
            ps.setBoolean(4, task.isStatys());
            ps.setInt(5, task.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlTaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private Task initTask(ResultSet rs, Employee emploue) throws SQLException{
        Task task = new Task();
        task.setId(rs.getInt(1));
        task.setEmploue(emploue);
        task.setInfoTask(rs.getString(5));
        task.setNumber(rs.getString(6));
        task.setDate(rs.getString(7));
        task.setPriority(rs.getString(8));
        task.setStatys(rs.getBoolean(9));
        task.setDelete(rs.getBoolean(10));
        return task;
    }

    public void deleteTask(int parameter) {
        String sql = "UPDATE tasks SET delete=true WHERE id=?";
        try (
                Connection connection = Connctors.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
            ){
            ps.setInt(1, parameter);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlTaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
