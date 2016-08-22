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
import kievreclama.task.entity.Enterprise;
import org.hibernate.Session;

/**
 *
 * @author firsachi
 */
public class CompanyDaoImpl implements CompanyDao{

    @Override
    public void add(Enterprise enterprise) throws SQLException {
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            session.beginTransaction();
            session.save(enterprise);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Enterprise enterprise) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(enterprise);
            session.getTransaction().commit();
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    @Override
    public void update(Enterprise enterprise) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.update(enterprise);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Enterprise find(Integer id) throws SQLException {
        Enterprise enterprise = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            enterprise = session.get(Enterprise.class, id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return enterprise;
    }

    @Override
    public List<Enterprise> getList() throws SQLException {
        List<Enterprise> resultLIst = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            resultLIst = session.createCriteria(Enterprise.class).list();
        }catch (Exception ex){
            
        }
        return  resultLIst;
    }
    
}
