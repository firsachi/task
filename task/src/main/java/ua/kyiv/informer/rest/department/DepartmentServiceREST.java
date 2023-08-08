package ua.kyiv.informer.rest.department;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.old.model.DepartmentModel;
import ua.kyiv.informer.logic.repository.DepartmentDaoImpl;

@Service
@Transactional
public class DepartmentServiceREST {

	private final DepartmentDaoImpl departmentDao;

	private final ModelMapper mapper;

	@Autowired
	public DepartmentServiceREST(DepartmentDaoImpl departmentDao, ModelMapper mapper) {
		this.departmentDao = departmentDao;
		this.mapper = mapper;
	}

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
