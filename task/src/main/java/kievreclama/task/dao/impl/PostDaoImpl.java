/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.PostDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Post;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author firsov
 */
public class PostDaoImpl implements PostDao{

    @Override
    public void add(Post post) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Post post) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(post);
        session.getTransaction().commit();
    }
    
    @Override
    public void update(Post post){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
    }

    @Override
    public Post find(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Post result = session.get(Post.class, id);
        session.getTransaction().commit();
        return result;
    }

    @Override
    public List<Post> list() throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Post.class).addOrder(Order.asc("id"));
        List<Post> resultList = criteria.list();
        return resultList;
    }
    
}
