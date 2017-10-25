package kievreclama.task.model.dao;

import java.util.List;

import kievreclama.task.entity.Room;

public interface RoomDao {
	
	void add(Room room);
	List<Room> all();
	Room byId(int id);
	void upadte(Room modelEntity);

}
