package informer.rest;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.repository.CompanyDaoImpl;
import informer.rest.model.CompanyModel;
import informer.rest.model.CompanyModelSmall;
import informer.rest.model.DepartmentModel;

@Service
public class CompanyServiceREST {
	
	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<CompanyModelSmall> getListModel(){
		return companyDao.byList("company").stream().map(company -> mapper.map(company, CompanyModelSmall.class)).collect(Collectors.toList());
	}
	
	public CompanyModel byCompany(int id) {
		CompanyModel company = mapper.map(companyDao.byId(id), CompanyModel.class);
		
		List<DepartmentModel> departments = company.getDepartments().stream()
				.map(department -> mapper.map(department, DepartmentModel.class))
				.sorted(Comparator.comparing(DepartmentModel::getName))
				.collect(Collectors.toList());
		company.setDepartments(departments);		
	//	company.setDepartments(company.getDepartments().stream().sorted().collect(Collectors.toList()));
		return company;
	}

}
