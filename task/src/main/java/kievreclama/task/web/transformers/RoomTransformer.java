package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.Room;
import kievreclama.task.web.models.RoomModel;

@Component
public class RoomTransformer {
	
	public RoomModel entityModel(Room entity) {
		RoomModel model = new RoomModel();
		model.setId(entity.getId());
		model.setNumberRoom(entity.getNumberRoom());
		return model;
	}
	
	public Room modelEntity(RoomModel model) {
		Room entity = new Room();
		entity.setId(model.getId());
		entity.setNumberRoom(model.getNumberRoom());
		return entity;
	}

}
