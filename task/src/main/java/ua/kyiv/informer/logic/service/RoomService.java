package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.logic.entity.Room;
import ua.kyiv.informer.logic.repository.RoomDaoImpl;
import ua.kyiv.informer.ui.room.RoomModel;

@Service("roomService")
public class RoomService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoomDaoImpl roomDao;
	
	@Transactional
	public void save(RoomModel room) {
		roomDao.insert(modelMapper.map(room, Room.class));
	}

	public RoomModel byId(int id) {
		return modelMapper.map(roomDao.byId(id), RoomModel.class);
	}

	public boolean findRoomNumber(String numberRoom) {
		return roomDao.findRoomNumber(numberRoom);
	}

	@Transactional
	public void update(RoomModel room) {
		roomDao.update(modelMapper.map(room, Room.class));
	}
	

	public List<RoomModel> all(String namedQery) {
		return roomDao.byList(namedQery).stream()
				.map(room -> modelMapper.map(room, RoomModel.class))
				.collect(Collectors.toList());
	}

	@Transactional
	public boolean delete(int id) {
		if (roomDao.byId(id).getEmployees().isEmpty()) {
			roomDao.delete(roomDao.byId(id));
			return true;
		} else {
			return false;
		}
		
	}

}
