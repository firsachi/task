package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.model.RoomModel;
import ua.kyiv.informer.logic.entity.Room;
import ua.kyiv.informer.logic.repository.RoomDaoImpl;

@Service("roomService")
public class RoomServiceImpl {

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

	@Transactional
	public void update(RoomModel room) {
		roomDao.update(modelMapper.map(room, Room.class));
	}
	

	public List<RoomModel> all(String namedQery) {
		return roomDao.byList(namedQery).stream()
				.map(room -> modelMapper.map(room, RoomModel.class))
				.collect(Collectors.toList());
	}
	/*
	@Override
	public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
		Assert.notNull(fieldName);
		if (!fieldName.equals("numberRoom")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }
        
        try {
        	Integer numberRoom = Integer.parseInt((String) value);
        	if (this.roomDao.existsByRoom(numberRoom).isEmpty()) {
            	return false;
            } else {
				return true;
			}
        	
        } catch (NumberFormatException e) {
        	return false;
		}
	}
*/
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
