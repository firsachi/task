package informer.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.entity.Room;
import informer.model.RoomModel;
import informer.repository.RoomDaoImpl;

@Service
public class RoomServiceImpl implements RoomService {

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
	

	public List<RoomModel> allRoom(String namedQery) {
		return roomDao.byList(namedQery).stream()
				.map(room -> modelMapper.map(room, RoomModel.class))
				.collect(Collectors.toList());
	}
	
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

	@Override
	@Transactional
	public boolean delete(Integer id) {
		if (roomDao.byId(id).getEmployees().isEmpty()) {
			roomDao.delete(roomDao.byId(id));
			return true;
		} else {
			return false;
		}
		
	}

}
