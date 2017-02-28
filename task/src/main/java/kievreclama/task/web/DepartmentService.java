package kievreclama.task.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.entity.Department;
import kievreclama.task.web.models.DepartmentModel;
import kievreclama.task.web.transformers.DepartmentTransformer;

@Component
public class DepartmentService extends ServiseTask<DepartmentModel>{
	
	@Autowired
	private DepartmentDaoImpl departmentDao;
	
	@Autowired 
	private DepartmentTransformer departmentTransformer;

	@Override
	public void save(DepartmentModel value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DepartmentModel value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartmentModel getId(int id) {
		// TODO Auto-generated method stub
		return null;
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
