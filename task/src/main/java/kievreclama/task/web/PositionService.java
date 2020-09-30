package kievreclama.task.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.PostDaoImpl;
import kievreclama.task.entity.Position;
import kievreclama.task.web.models.PositionModel;

@Service
public class PositionService extends ServiseTask<PositionModel> {

	@Autowired
	private PostDaoImpl postDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public void save(PositionModel value) {
		System.out.println(value);
		postDao.update(modelMapper.map(value, Position.class));
	}

	@Override
	public void update(PositionModel value) {
		postDao.update(modelMapper.map(value, Position.class));
	}

	@Override
	@Transactional
	public void delete(int id) {
		postDao.delete(postDao.byId(id));
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
