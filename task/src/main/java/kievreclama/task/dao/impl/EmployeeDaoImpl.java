/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.EmployeeDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Employee;
import org.hibernate.Session;

/**
 *
 * @author firsov
 */
public class EmployeeDaoImpl implements EmployeeDao{
    
    @Override
    public void add(Employee employee) throws SQLException{
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }
    
    @Override
    public void update(Employee employee) throws SQLException{
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }
    
    @Override
    public Employee find(Integer id) throws SQLException {
        Employee employee;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
        }
        return employee;
    }
    
    @Override
    public Employee find(String lvalue) throws SQLException{
        Employee employee = new Employee();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Employee> list = session.createQuery("from Employee where login = :lvalue").setString("lvalue", lvalue).list();
            employee= list.get(0);
            session.getTransaction().commit();
        }
        return employee;
    }
    
    @Override
    public List<Employee> getList() throws SQLException {
        List<Employee> result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Employee").list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public List<Employee> getList(Integer id) throws SQLException {
        List<Employee> result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "from Employee where department = :value and remove = false";
            result = session.createQuery(hql).setInteger("value", id).list();
            session.getTransaction().commit();
        }
        return result;
    }
}
