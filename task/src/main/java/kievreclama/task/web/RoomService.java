package kievreclama.task.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.model.FactoryDao;
import kievreclama.task.model.dao.RoomDao;
import kievreclama.task.web.models.RoomModel;
import kievreclama.task.web.transformers.RoomTransformer;

@Service
public class RoomService {

	@Autowired
	private FactoryDao factoryDao;
	
	@Autowired
	private RoomDaoImpl roomDao;
	
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
	
	@Transactional
	public List<RoomModel> allRoom(String namedQery) {
		return roomDao.byList(namedQery).stream()
				.map(room -> roomTransformer.entityModel(room))
				.collect(Collectors.toList());
	}
	
}
