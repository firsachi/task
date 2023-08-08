package ua.kyiv.informer.rest.company;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.old.model.DepartmentModel;
import ua.kyiv.informer.logic.entity.Company;
import ua.kyiv.informer.logic.repository.CompanyDaoImpl;

@Service
public class CompanyServiceREST {
	
	private CompanyDaoImpl companyDao;

	private ModelMapper mapper;

	@Autowired
	public CompanyServiceREST(CompanyDaoImpl companyDao, ModelMapper mapper) {
		this.companyDao = companyDao;
		this.mapper = mapper;
	}

	public List<CompanyModel> getListModel(){
		return companyDao.byList("company").stream().map(company -> mapper(company)).collect(Collectors.toList());
	}
	
	public CompanyModel byCompany(int id) {		
		return mapper(companyDao.byId(id));
	}
	
	private CompanyModel mapper(Company ent) {
		CompanyModel company = mapper.map(ent, CompanyModel.class);
		
		List<DepartmentModel> departments = company.getDepartments().stream()
				.map(department -> mapper.map(department, DepartmentModel.class))
				.sorted(Comparator.comparing(DepartmentModel::getName))
				.collect(Collectors.toList());
		company.setDepartments(departments);
		return company;
	}

}
