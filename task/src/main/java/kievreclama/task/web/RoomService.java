package kievreclama.task.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.entity.Room;
import kievreclama.task.web.models.RoomModel;

@Service
public class RoomService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoomDaoImpl roomDao;

	@Transactional
	public void save(RoomModel room) {
		roomDao.insert(modelMapper.map(room, Room.class));
	}

	public Object byId(int id) {
		return modelMapper.map(roomDao.byId(id), RoomModel.class);
	}

	@Transactional
	public void update(RoomModel room) {
		roomDao.update(modelMapper.map(room, Room.class));
	}
	
	@Transactional
	public List<RoomModel> allRoom(String namedQery) {
		return roomDao.byList(namedQery).stream()
				.map(room -> modelMapper.map(room, RoomModel.class))
				.collect(Collectors.toList());
	}
	
}
