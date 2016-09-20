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
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Room.class);
        List<Room> resultList = criteria.list();
        session.getTransaction().commit();
        return  resultList;
    }

    @Override
    public Room find(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Room room = session.get(Room.class, id);
        return  room;
    }
    
}
