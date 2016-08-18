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
    public List<Employee> getList() throws SQLException {
        List<Employee> resultLst = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            resultLst = session.createCriteria(Employee.class).list();
        }catch (Exception ex){
            
        }finally{
            session.close();
        }
        return resultLst;
    }
    
}
