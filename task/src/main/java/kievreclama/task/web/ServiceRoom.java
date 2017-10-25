package kievreclama.task.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.RoomDao;
import kievreclama.task.web.models.RoomModel;
import kievreclama.task.web.transformers.RoomTransformer;

@Service
public class ServiceRoom {

	@Autowired
	private FactoryDao factoryDao;
	
	@Autowired
	private RoomTransformer roomTransformer;

	public void add(RoomModel model) {
		RoomDao roomDao = factoryDao.createRoomDao();
		roomDao.add(roomTransformer.modelEntity(model));
	}

	public Object byId(int id) {
		RoomDao roomDao = factoryDao.createRoomDao();
		return roomTransformer.entityModel(roomDao.byId(id));
	}

	public void update(RoomModel room) {
		RoomDao roomDao = factoryDao.createRoomDao();
		roomDao.upadte(roomTransformer.modelEntity(room));
	}
	
}
