package informer.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.entity.Department;
import informer.model.DepartmentModel;
import informer.old.transformer.DepartmentTransformer;
import informer.repository.DepartmentDaoImpl;

@Service
@Transactional
public class DepartmentService extends ServiseTask<DepartmentModel>{
	
	@Autowired
	private DepartmentDaoImpl departmentDao;
	
	@Autowired 
	private DepartmentTransformer departmentTransformer;

	@Override
	public void save(DepartmentModel value) {
		departmentDao.insert(departmentTransformer.modelToEntity(value));
		
	}

	@Override
	public void update(DepartmentModel value) {
		departmentDao.update(departmentTransformer.modelToEntity(value));
	}

	public void delete(int id) {
		departmentDao.delete(departmentDao.byId(id));
	}

	@Override
	public DepartmentModel getId(int id) {
		return departmentTransformer.entityToModel(departmentDao.byId(id));
	}

	@Override
	public List<DepartmentModel> getList(String namedQery) {
		List<DepartmentModel> list = new ArrayList<>();
		for (Department department: departmentDao.byList(namedQery)){
			list.add(departmentTransformer.entityToModel(department));
		}
		return list;
	}

}
