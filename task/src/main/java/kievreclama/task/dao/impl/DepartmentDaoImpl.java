/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import kievreclama.task.dao.DepartmentDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Department;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

/**
 *
 * @author firsov
 */
public class DepartmentDaoImpl implements DepartmentDao{

	@Inject
	private SessionFactory sessionFactory;
		
    @Override
    public void add(Department department) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Department department) throws SQLException {
        department.setDelete(true);
        update(department);
    }

    @Override
    public void update(Department department) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(department);
        session.getTransaction().commit();
    }

    @Override
    public Department find(Integer id) throws SQLException {
        Department result;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        result = session.get(Department.class, id);
        result.getEmployees().size();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public List<Department> list() throws SQLException {
        List<Department> resultList;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Department.class).addOrder(Order.asc("name"));
        resultList = criteria.list();
        session.getTransaction().commit();
        return resultList;
    }
    
}
