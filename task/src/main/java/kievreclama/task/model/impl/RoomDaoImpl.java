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

	@Override
	public void add(Room room) {
		Session session = sessionFactory.getCurrentSession();
		session.save(room);
	}

	@Override
	@Transactional
	public Room byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Room.class, id);
	}

	@Override
	public void upadte(Room room) {
		Session session = sessionFactory.getCurrentSession();
		session.update(room);
	}

}
