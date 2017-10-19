package kievreclama.task.model.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.entity.Room;
import kievreclama.task.model.dao.RoomDao;

@Repository
public class RoomDaoImpl implements RoomDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Room> all() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Room> rooms = session.createNamedQuery("allRooms", Room.class);
		return rooms.getResultList();
	}

}
