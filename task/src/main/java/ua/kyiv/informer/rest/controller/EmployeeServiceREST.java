package ua.kyiv.informer.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.rest.model.EmployeeModel;
import informer.rest.model.FilterParm;
import ua.kyiv.informer.logic.repository.EmployeeDaoImpl;

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
