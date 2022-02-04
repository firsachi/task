package informer.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.entity.Position;
import informer.model.PositionModel;
import informer.repository.PositionDaoImpl;

@Service
public class PositionService extends ServiseTask<PositionModel> {

	@Autowired
	private PositionDaoImpl postDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public void save(PositionModel value) {
		postDao.update(modelMapper.map(value, Position.class));
	}

	@Transactional
	@Override
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

	@Override
	public PositionModel getId(int id) {
		return modelMapper.map(postDao.byId(id), PositionModel.class);
	}

	@Override
	public List<PositionModel> getList(String namedQery) {
		return postDao.byList(namedQery).stream().map(entity -> modelMapper.map(entity, PositionModel.class))
				.collect(Collectors.toList());
	}

}
