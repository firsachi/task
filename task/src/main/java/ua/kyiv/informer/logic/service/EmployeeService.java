package ua.kyiv.informer.logic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.model.EmployeeModel;
import informer.model.EmployeelLiteModel;
import informer.old.transformer.EmployeeTransformer;
import ua.kyiv.informer.logic.repository.CompanyDaoImpl;
import ua.kyiv.informer.logic.repository.DepartmentDaoImpl;
import ua.kyiv.informer.logic.repository.EmployeeDaoImpl;
import ua.kyiv.informer.logic.repository.PhoneDaoImpl;
import ua.kyiv.informer.logic.repository.PositionDaoImpl;
import ua.kyiv.informer.logic.repository.RoomDaoImpl;

@Service
public class EmployeeService extends ServiseTask<EmployeeModel> {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	@Autowired
	private EmployeeTransformer employeeTransformer;

	@Autowired
	private RoomDaoImpl roomDao;

	@Autowired
	private PhoneDaoImpl phoneDao;

	@Autowired
	private PositionDaoImpl postDao;

	@Autowired
	private DepartmentDaoImpl departmentDao;

	@Autowired
	private CompanyDaoImpl comapnyDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public void save(EmployeeModel value) {
		value = setDefaultPhoneRomm(value);
		employeeDao.insert(employeeTransformer.modelToEntity(value));
	}

	@Override
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

	@Override
	public EmployeeModel getId(int id) {
		return employeeTransformer.entityToModel(employeeDao.byId(id));
	}
	
	public EmployeelLiteModel byLiteModel(int id) {
		return modelMapper.map(employeeDao.byId(id), EmployeelLiteModel.class);
	}

	@Override
	public List<EmployeeModel> getList(String namedQery) {
		return employeeDao.byList(namedQery).stream().map(entity -> employeeTransformer.entityToModel(entity))
				.collect(Collectors.toList());
	}

	public Map<String, List<?>> allCompnents() {
		Map<String, List<?>> mapResult = new HashMap<>();
		mapResult.put("listCompany", comapnyDao.byList("company"));
		mapResult.put("listDepartment", departmentDao.byList("department"));
		mapResult.put("listPost", postDao.byList("posts"));
		mapResult.put("listRoom", roomDao.byList("allRooms"));
		mapResult.put("listPhone", phoneDao.byList("allPhone"));
		return mapResult;
	}

	public Set<EmployeelLiteModel> getEmployeeLite() {
		boolean disable = false;
		return employeeDao.byList("selectEmployee", disable).stream().parallel()
				.map(entityEmployee -> modelMapper.map(entityEmployee, EmployeelLiteModel.class))
				.collect(Collectors.toSet());
	}
}
