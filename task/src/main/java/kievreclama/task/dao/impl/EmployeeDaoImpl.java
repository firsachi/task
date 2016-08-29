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
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
            
    }
    
    @Override
    public void update(Employee employee) throws SQLException{
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    

    @Override
    public Employee find(Employee employee) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            employee = session.get(Employee.class, employee.getId());
            session.getTransaction().commit();
            return employee;
        }catch(Exception ex){
            
        }
        return employee;
    }
    
    @Override
    public List<Employee> getList() throws SQLException {
        List<Employee> resultLst = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            resultLst = session.createCriteria(Employee.class).list();
        }catch (Exception ex){
            
        }
        return resultLst;
    }
    
}
