/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.PhoneDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Phone;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author firsachi
 */
public class PhoneDaoImpl implements PhoneDao{
    
    @Override
    public Phone find(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Phone phone = session.get(Phone.class, id);
        return phone;
    }

    @Override
    public List<Phone> list() throws SQLException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Phone.class);
        List<Phone> resultList = criteria.list();
        return resultList;
    }
    
}
