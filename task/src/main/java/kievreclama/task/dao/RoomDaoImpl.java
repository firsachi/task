package kievreclama.task.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import kievreclama.task.entity.Room;

@Repository("roomDao")
public class RoomDaoImpl extends MainDao<Room>{

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Room byId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Room> listRoom = session.createNamedQuery("allRooms", Room.class);
		return listRoom.getResultList();
	}

}
