package kievreclama.task.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.web.models.RoomModel;
import kievreclama.task.web.transformers.RoomTransformer;

@Service
public class ServiceRoom {

	@Autowired
	private RoomDaoImpl roomDao;
	
	@Autowired
	private RoomTransformer roomTransformer;

	public void add(RoomModel model) {
		roomDao.insert(roomTransformer.modelEntity(model));
	}

	public Object byId(int id) {
		return roomTransformer.entityModel(roomDao.byId(id));
	}

	public void update(RoomModel room) {
		roomDao.update(roomTransformer.modelEntity(room));
	}
	
}
