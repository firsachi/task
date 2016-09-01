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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author firsov
 */
public class TaskDaoImpl implements TaskDao{

    @Override
    public void add(Task task) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Task task) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
        }
    }

    @Override
    public Task findId(int id) throws SQLException {
        Task task = null;
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            task = session.get(Task.class, id);
        }
        return task;
    }

    @Override
    public List<Task> list() throws SQLException {
        List<Task> listTasks = null;
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Task.class).addOrder(Order.asc("urgensy"));
            listTasks = criteria.list();
            session.getTransaction().commit();
        }
        return listTasks;
    }

    @Override
    public List<Task> list(int employeeId) throws SQLException{
        List<Task> listTasks = null;
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            listTasks = (List<Task>) session.createQuery("FROM Task WHERE employee = :number").setInteger("number", employeeId).list();
        }
        return listTasks;
    }
    
}
