package informer.rest;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.old.ModelDepartment;
import informer.repository.DepartmentDaoImpl;

@Service
@Transactional
public class DepartmentServiceREST {
	
	@Autowired
	private DepartmentDaoImpl departmentDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Transactional
	public ModelDepartment byDepartment(int id) {
		return mapper.map( departmentDao.byId(id), ModelDepartment.class);
	}

}
