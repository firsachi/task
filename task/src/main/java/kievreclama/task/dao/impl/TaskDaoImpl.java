/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.TaskDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Task;
import org.hibernate.Session;

/**
 *
 * @author firsov
 */
public class TaskDaoImpl implements TaskDao{

    @Override
    public void add(Task task) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            session.getTransaction();
            session.save(task);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Task task) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            session.getTransaction();
            session.delete(task);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Task find(int id) throws SQLException {
        Task result = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            result = (Task) session.load(Task.class, id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Task> getList() throws SQLException {
        List<Task> resultList = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            resultList = session.createCriteria(Task.class).list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return resultList;
    }
    
}
