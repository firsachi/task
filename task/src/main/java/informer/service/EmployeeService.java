package informer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.db.CompanyDaoImpl;
import informer.db.DepartmentDaoImpl;
import informer.db.EmployeeDaoImpl;
import informer.db.PhoneDaoImpl;
import informer.db.PositionDaoImpl;
import informer.db.RoomDaoImpl;
import informer.model.EmployeeModel;
import informer.old.transformer.EmployeeTransformer;

@Service
public class EmployeeService extends ServiseTask<EmployeeModel>{
	
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

	@Override
	@Transactional
	public void save(EmployeeModel value) {
		employeeDao.insert(employeeTransformer.modelToEntity(value));
	}

	@Override
	@Transactional
	public void update(EmployeeModel value) {
		employeeDao.update(employeeTransformer.modelToEntity(value));
	}

	public void delete(int id) {
		employeeDao.delete(employeeDao.byId(id));
	}

	@Override
	public EmployeeModel getId(int id) {
		return employeeTransformer.entityToModel(employeeDao.byId(id));
	}

	@Override
	public List<EmployeeModel> getList(String namedQery) {
		return employeeDao.byList(namedQery)
				.stream().map(entity -> employeeTransformer.entityToModel(entity))
				.collect(Collectors.toList());
	}

	public Map<String, List<?>> allCompnents(){
		Map<String, List<?>> mapResult = new HashMap<>();
		mapResult.put("listCompany", comapnyDao.byList("company"));
		mapResult.put("listDepartment", departmentDao.byList("department"));
		mapResult.put("listPost", postDao.byList("posts"));
		mapResult.put("listRoom", roomDao.byList("allRooms"));
		mapResult.put("listPhone", phoneDao.byList("allPhone"));
		return mapResult;
	}
}
