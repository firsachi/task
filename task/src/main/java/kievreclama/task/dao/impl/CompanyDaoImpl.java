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
 */
public class CompanyDaoImpl implements CompanyDao{

    @Override
    public void add(Company enterprise) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            session.beginTransaction();
            session.save(enterprise);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Company enterprise) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(enterprise);
            session.getTransaction().commit();
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    @Override
    public void update(Company enterprise) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.update(enterprise);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Company find(Integer id) throws SQLException {
        Company enterprise = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            enterprise = session.get(Company.class, id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return enterprise;
    }

    @Override
    public List<Company> getList() throws SQLException {
        List<Company> resultLIst = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            Criteria criteria = session.createCriteria(Company.class).addOrder(Order.asc("id"));
            resultLIst = criteria.list();
        }catch (Exception ex){
            
        }
        return  resultLIst;
    }
    
}
