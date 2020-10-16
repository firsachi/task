package informer.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.entity.Department;
import informer.model.DepartmentModel;
import informer.repository.DepartmentDaoImpl;

@Service
@Transactional
public class DepartmentService extends ServiseTask<DepartmentModel>{
	
	@Autowired
	private DepartmentDaoImpl departmentDao;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public void save(DepartmentModel value) {
		departmentDao.insert(modelMapper.map(value, Department.class));
		
	}

	@Override
	public void update(DepartmentModel value) {
		departmentDao.update(modelMapper.map(value, Department.class));
	}

	public void delete(int id) {
		departmentDao.delete(departmentDao.byId(id));
	}

	@Override
	public DepartmentModel getId(int id) {
		return modelMapper.map(departmentDao.byId(id), DepartmentModel.class);
	}

	@Override
	public List<DepartmentModel> getList(String namedQery) {
		return departmentDao.byList(namedQery).stream()
				.map(department -> modelMapper.map(department, DepartmentModel.class))
				.collect(Collectors.toList());
	}

}
