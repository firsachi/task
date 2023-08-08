package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.logic.entity.Position;
import ua.kyiv.informer.logic.repository.PositionDaoImpl;
import ua.kyiv.informer.ui.position.PositionModel;

@Service
public class PositionService {

	private final PositionDaoImpl postDao;

	private final ModelMapper modelMapper;

	@Autowired
	public PositionService(PositionDaoImpl postDao, ModelMapper modelMapper) {
		this.postDao = postDao;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public void save(PositionModel value) {
		postDao.update(modelMapper.map(value, Position.class));
	}

	@Transactional
	public void update(PositionModel value) {
		postDao.update(modelMapper.map(value, Position.class));
	}

	@Transactional
	public boolean delete(int id) {
		if (0 == postDao.byId(id).getEmployees().size()) {
			postDao.delete(postDao.byId(id));
			return false;
		}
		return true;
	}

	public PositionModel getId(int id) {
		return modelMapper.map(postDao.byId(id), PositionModel.class);
	}

	public List<PositionModel> getList(String namedQery) {
		return postDao.byList(namedQery).stream().map(entity -> modelMapper.map(entity, PositionModel.class))
				.collect(Collectors.toList());
	}

    public boolean isUnique(PositionModel model) {
		return postDao.isUnique(modelMapper.map(model, Position.class));
    }
}
