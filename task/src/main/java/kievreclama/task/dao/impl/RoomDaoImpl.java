/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.sql.SQLException;
import java.util.List;
import kievreclama.task.dao.RoomDao;
import kievreclama.task.dao.hibernate.HibernateUtil;
import kievreclama.task.entity.Room;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author firsov
 */
public class RoomDaoImpl implements RoomDao{

    @Override
    public List<Room> list() throws SQLException {
        List<Room> resultList = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Room.class);
        resultList = criteria.list();
        session.getTransaction().commit();
        return  resultList;
    }

    @Override
    public Room find(Integer id) throws SQLException {
        Room room = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            room = session.get(Room.class, id);
        }
        return  room;
    }
    
}
