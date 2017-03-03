package kievreclama.task.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kievreclama.task.dao.EmployeeDaoImpl;
import kievreclama.task.dao.RoomDaoImpl;
import kievreclama.task.entity.Employee;
import kievreclama.task.web.models.EmployeeModel;
import kievreclama.task.web.transformers.EmployeeTransformer;

@Component
public class EmployeeService extends ServiseTask<EmployeeModel>{
	
	@Autowired
	private EmployeeDaoImpl employeeDao;
	
	@Autowired
	private EmployeeTransformer employeeTransformer;
	
	@Autowired
	private RoomDaoImpl roomDao;

	@Override
	public void save(EmployeeModel value) {
		
	}

	@Override
	public void update(EmployeeModel value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeModel getId(int id) {
		// TODO Auto-generated method stub
		return null;
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
		//mapResult.put("enterprise", new CompanyDaoImpl().byList("company"));
		mapResult.put("numberRoom", roomDao.byList("allRooms"));
		return mapResult;
	}
}
