package informer.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.db.EmployeeDaoImpl;
import informer.rest.model.EmployeeModel;
import informer.rest.model.FilterParm;

@Service
@Transactional
public class EmployeeServiceREST {
	
	@Autowired
	private  EmployeeDaoImpl repositoryEmployee;
	
	@Autowired
	private ModelMapper mapper;
	
	@Transactional
	public List<EmployeeModel> getListEmployeeDepartment(FilterParm filterParm){
		return repositoryEmployee.byList("employeeDepartment", filterParm.getCompanyId(), filterParm.getDeparmentId())
				.stream().map(employee -> mapper.map(employee, EmployeeModel.class))
				.collect(Collectors.toList());
	}
	
}
