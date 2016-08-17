/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.UrgencyDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Urgency;
import org.hibernate.Session;

/**
 *
 * @author firsov
 */
public class UrgencyDaoImpl implements UrgencyDao{

    @Override
    public List<Urgency> getList() throws SQLException {
        List<Urgency> resultList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            resultList = session.createCriteria(Urgency.class).list();
        } catch (Exception e) {
        }
        return resultList;
    }
    
}
