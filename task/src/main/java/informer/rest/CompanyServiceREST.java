package informer.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import informer.repository.CompanyDaoImpl;
import informer.rest.model.CompanyModel;
import informer.rest.model.CompanyModelSmall;

@Service
public class CompanyServiceREST {
	
	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<CompanyModelSmall> getListModel(){
		return companyDao.byList("company").stream().map(company -> mapper.map(company, CompanyModelSmall.class)).toList();
	}
	
	public CompanyModel byCompany(int id) {
		return mapper.map(companyDao.byId(id), CompanyModel.class);
	}

}
