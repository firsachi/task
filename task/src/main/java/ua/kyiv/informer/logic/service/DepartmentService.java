package ua.kyiv.informer.logic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.logic.entity.Company;
import ua.kyiv.informer.logic.entity.Department;
import ua.kyiv.informer.logic.repository.DepartmentDaoImpl;
import ua.kyiv.informer.rest.department.DepartmentFormModel;
import ua.kyiv.informer.rest.department.DepartmentModel;

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	private DepartmentDaoImpl departmentDao;
	
	@Autowired 
	private ModelMapper modelMapper;

	public void save(DepartmentFormModel value) {
		Department department = modelMapper.map(value, Department.class);
		department.setCompanies(value.getCompanies().stream().map(id -> new Company(id)).collect(Collectors.toList()));
		departmentDao.insert(department);
	}

	public void update(DepartmentFormModel value) {
		Department department = modelMapper.map(value, Department.class);
		department.setCompanies(value.getCompanies().stream().map(id -> new Company(id)).collect(Collectors.toList()));
		departmentDao.update(department);
	}

	@Transactional
	public void delete(DepartmentFormModel model) {
		departmentDao.delete(departmentDao.byId(model.getId()));
	}

	public DepartmentFormModel getId(int id) {
		Department department = departmentDao.byId(id);
		List<Integer> companies = department.getCompanies().stream()
				.map(entiry -> entiry.getId())
				.collect(Collectors.toList());
		DepartmentFormModel model = new DepartmentFormModel().newBuilder()
				.setId(department.getId()).
				setName(department.getName())
				.setDisable(department.isDisable())
				.setCompanies(companies)
				.build();
		return model;
	}

	public List<DepartmentModel> getList(String namedQery) {
		return departmentDao.byList(namedQery).stream()
				.map(department -> modelMapper.map(department, DepartmentModel.class))
				.collect(Collectors.toList());
	}

	public Map<String, Boolean> findQnique(DepartmentFormModel model) {
		Department department = modelMapper.map(model, Department.class);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		result.put(model.getName(), departmentDao.existsName(department.getId(), department.getName()));
		return result;
	}

}
