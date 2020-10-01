package kievreclama.task.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.dao.impl.DepartmentDaoImpl;
import kievreclama.task.dao.impl.EmployeeDaoImpl;
import kievreclama.task.dao.impl.PhoneDaoImpl;
import kievreclama.task.dao.impl.PositionDaoImpl;
import kievreclama.task.dao.impl.RoomDaoImpl;
import kievreclama.task.entity.Employee;
import kievreclama.task.web.models.EmployeeModel;
import kievreclama.task.web.transformers.EmployeeTransformer;

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
		List<EmployeeModel> listResult = new ArrayList<EmployeeModel>();
		for (Employee entity: employeeDao.byList(namedQery)){
			listResult.add(employeeTransformer.entityToModel(entity));
		}
		return listResult;
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
