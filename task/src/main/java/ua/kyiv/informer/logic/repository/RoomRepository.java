package ua.kyiv.informer.logic.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ua.kyiv.informer.logic.entity.Room;

import jakarta.persistence.TypedQuery;

@Repository("roomDao")
public class RoomRepository extends MainDao<Room>{

	@Override
	public Room byId(int id) {
		return em.find(Room.class, id);
	}

	@Override
	public List<Room> byList(String namedQery) {
		TypedQuery<Room> listRoom = em.createNamedQuery("allRooms", Room.class);
		return listRoom.getResultList();
	}
	
	@Override
	public void insert(Room value){
		em.merge(value);
	}

	public  boolean findRoomNumber(String numberRoom) {
		return em.createNamedQuery("findNumberRoom", Room.class).setParameter("numberRoom", numberRoom).getResultList().isEmpty();
	}

}
