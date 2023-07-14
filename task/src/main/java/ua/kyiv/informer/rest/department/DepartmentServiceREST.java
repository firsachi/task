package ua.kyiv.informer.rest.department;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.rest.model.DepartmentModel;
import ua.kyiv.informer.logic.repository.DepartmentDaoImpl;

@Service
@Transactional
public class DepartmentServiceREST {
	
	@Autowired
	private DepartmentDaoImpl departmentDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Transactional
	public DepartmentModel byDepartment(int id) {
		return mapper.map( departmentDao.byId(id), DepartmentModel.class);
	}

	@Transactional
	public List<DepartmentModel> getListDepartments() {
		return departmentDao.byList("allDepartments")
				.stream().map(department -> mapper.map(department, DepartmentModel.class))
				.collect(Collectors.toList());
	}

}
