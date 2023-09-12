package ua.kyiv.informer.rest.employee;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.old.model.EmployeeModel;
import ua.kyiv.informer.old.model.FilterParm;
import ua.kyiv.informer.logic.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceREST {

	private final EmployeeRepository repositoryEmployee;

	private final ModelMapper mapper;

	@Autowired
	public EmployeeServiceREST(EmployeeRepository employeeRepository, ModelMapper mapper){
		this.repositoryEmployee = employeeRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	public List<EmployeeModel> getListEmployeeDepartment(FilterParm filterParm){
		return repositoryEmployee.byList("employeeDepartment", filterParm.getCompanyId(), filterParm.getDeparmentId())
				.stream().map(employee -> mapper.map(employee, EmployeeModel.class))
				.collect(Collectors.toList());
	}
	
}
