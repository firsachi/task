package kievreclama.task.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kievreclama.task.dao.CompanyDaoImpl;
import kievreclama.task.entity.Company;
import kievreclama.task.web.models.CompanyModel;
import kievreclama.task.web.transformers.CompanyTransformer;

@Component
public class CompanyService extends ServiseTask<CompanyModel>{
	
	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private CompanyTransformer companyTransformer;

	@Override
	public void save(CompanyModel value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyModel value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CompanyModel value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CompanyModel> getList(String namedQery) {
		List<CompanyModel> result = new ArrayList<>();
		for (Company company: companyDao.byList(namedQery)){
			result.add(companyTransformer.entityToModel(company));
		}
		return result;
	}

}
