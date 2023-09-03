package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import ua.kyiv.informer.logic.entity.Employee;
import ua.kyiv.informer.logic.repository.DepartmentDaoImpl;
import ua.kyiv.informer.logic.repository.EmployeeDaoImpl;
import ua.kyiv.informer.logic.repository.PositionDaoImpl;
import ua.kyiv.informer.old.EmployeeTransformer;
import ua.kyiv.informer.rest.employee.EmployeeModel;
import ua.kyiv.informer.rest.employee.EmployeelLiteModel;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	@Autowired
	private EmployeeTransformer employeeTransformer;

	@Autowired
	private PositionDaoImpl postDao;

	@Autowired
	private DepartmentDaoImpl departmentDao;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public void save(EmployeeModel employeeModel) {
		Employee employee = modelMapper.map(employeeModel, Employee.class);
		employee.setDepartment(departmentDao.findNameDepartment(employeeModel.getDepartment()));
		employee.setPosition(postDao.findNamePosition(employeeModel.getPost()));
		if (0 == employee.getPhone().getId()) {
			employee.getPhone().setId(1);
		}
		if (0 == employee.getRoom().getId()) {
			employee.getRoom().setId(1);
		}
		employeeDao.insert(employee);
	}

	@Transactional
	public void update(EmployeeModel value) {
		value = setDefaultPhoneRomm(value);
		employeeDao.update(employeeTransformer.modelToEntity(value));
	}

	private EmployeeModel setDefaultPhoneRomm(EmployeeModel value) {
		if (0 == value.getIdPhone()) {
			value.setIdPhone(1);
			value.setPhone("0");
		}
		if (0 == value.getIdRoom()) {
			value.setIdRoom(1);
			value.setRoom(0);
		}
		return value;
	}

	@Transactional
	public void delete(int id) {
		employeeDao.delete(employeeDao.byId(id));
	}

	public EmployeeModel getId(int id) {
		return employeeTransformer.entityToModel(employeeDao.byId(id));
	}
	
	public EmployeelLiteModel byLiteModel(int id) {
		return modelMapper.map(employeeDao.byId(id), EmployeelLiteModel.class);
	}

	public List<EmployeeModel> getList(String namedQery) {
		return employeeDao.byList(namedQery).stream().map(entity -> employeeTransformer.entityToModel(entity))
				.collect(Collectors.toList());
	}

	public Set<EmployeelLiteModel> getEmployeeLite() {
		boolean disable = false;
		return employeeDao.byList("selectEmployee", disable).stream().parallel()
				.map(entityEmployee -> modelMapper.map(entityEmployee, EmployeelLiteModel.class))
				.collect(Collectors.toSet());
	}
}
