/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.CompanyDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Company;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author firsachi
 * @param <T>
 */
public class CompanyDaoImpl<T> implements CompanyDao<T>{
	
	private T value;
	
    public CompanyDaoImpl(T value) {
		super();
		this.value = value;
	}

	@Override
    public void add(T enterprise) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(enterprise);
        session.getTransaction().commit();
    }

    @Override
    public void delete(T enterprise) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(enterprise);
        session.getTransaction().commit();
    }

    @Override
    public void update(T enterprise) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(enterprise);
        session.getTransaction().commit();
    }

	@Override
    public T find(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        value = (T)session.get(Company.class, id);
        session.getTransaction().commit();
        return value;
    }
    
    @Override
    public List<T> getList() throws SQLException {
        List<T> resultLIst;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Company.class).addOrder(Order.asc("id"));
        resultLIst = criteria.list();
        session.getTransaction().commit();
        return  resultLIst;
    }
 
}
