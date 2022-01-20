package informer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.entity.Company;
import informer.entity.Department;
import informer.model.DepartmentCoreModel;
import informer.model.DepartmentFormModel;
import informer.model.DepartmentModel;
import informer.repository.DepartmentDaoImpl;

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

	public void update(DepartmentCoreModel value) {
		departmentDao.update(modelMapper.map(value, Department.class));
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
				.setPhone(department.getPhone())
				.setDisable(department.isDisable())
				.setCompanies(companies)
				.setAtsGroup(String.valueOf(department.getAtsGroup()))
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
		if (0 < department.getAtsGroup()) {
			result.put(model.getAtsGroup(), departmentDao.existsAtsGroup(department.getId(), department.getAtsGroup()));
		} else {
			result.put(model.getAtsGroup(), true);
		}
		return result;
	}

}
