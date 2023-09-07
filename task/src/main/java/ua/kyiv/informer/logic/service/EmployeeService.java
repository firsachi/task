package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import ua.kyiv.informer.logic.entity.Employee;
import ua.kyiv.informer.logic.entity.Phone;
import ua.kyiv.informer.logic.entity.Room;
import ua.kyiv.informer.logic.repository.*;
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
	private PhoneRepository phoneRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public void save(EmployeeModel employeeModel) {
		employeeDao.insert(mapModelEntity(employeeModel));
	}

	@Transactional
	public void update(EmployeeModel employeeModel) {
		employeeDao.update(mapModelEntity(employeeModel));
	}

	private Employee mapModelEntity(EmployeeModel employeeModel){
		Employee employee = modelMapper.map(employeeModel, Employee.class);
		employee.setDepartment(departmentDao.findNameDepartment(employeeModel.getDepartment()));
		employee.setPosition(postDao.findNamePosition(employeeModel.getPost()));
		employee.setPhone(isFindPhone(employee.getPhone().getId()));
		employee.setRoom(isfFindRoom(employeeModel.getIdRoom()));
		return employee;
	}

	private Phone isFindPhone(int id) {
		if (0 == id){
			id = 1;
		}
		return phoneRepository.byId(id);
	}

	private Room isfFindRoom(int id) {
		if (0 == id) {
			id = 1;
		}
		return roomRepository.byId(id);
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
