package informer.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import informer.entity.Room;

@Repository("roomDao")
public class RoomDaoImpl extends MainDao<Room>{

	@Override
	public Room byId(int id) {
		return em.find(Room.class, id);
	}

	@Override
	public List<Room> byList(String namedQery) {
		TypedQuery<Room> listRoom = em.createNamedQuery("allRooms", Room.class);
		return listRoom.getResultList();
	}

	public List<Room> existsByRoom(Integer numberRoom) {
		return em.createNamedQuery("fingNumberRoom", Room.class).setParameter("numberRoom", numberRoom).getResultList();
	}

}
