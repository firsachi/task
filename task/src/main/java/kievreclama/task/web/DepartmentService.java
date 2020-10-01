package kievreclama.task.web;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.entity.Department;
import kievreclama.task.web.models.DepartmentModel;
import kievreclama.task.web.transformers.DepartmentTransformer;

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
