package kievreclama.task.web;

import org.springframework.beans.factory.annotation.Autowired;

import antlr.collections.List;
import kievreclama.task.dao.CompanyDaoImpl;
import kievreclama.task.entity.Company;
import kievreclama.task.web.models.CompanyModel;
import kievreclama.task.web.transformers.CompanyTransformer;

public class CompanyService extends ServiseTask<Company>{
	
	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private CompanyTransformer companyTransformer;

	@Override
	void save(Company value) {
		companyDao.insert(companyTransformer.modelToEntity(new CompanyModel()));
	}

	@Override
	void update(Company value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void delete(Company value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	List getList() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
