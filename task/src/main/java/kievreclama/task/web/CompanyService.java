package kievreclama.task.web;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.entity.Company;
import kievreclama.task.web.models.CompanyModel;
import kievreclama.task.web.transformers.CompanyTransformer;

@Service
@Transactional
public class CompanyService extends ServiseTask<CompanyModel>{
	
	@Autowired
	private CompanyDaoImpl companyDao;
	
	@Autowired
	private CompanyTransformer companyTransformer;

	@Override
	public void save(CompanyModel value) {
		companyDao.insert(companyTransformer.modelToEntity(value));
	}

	@Override
	public void update(CompanyModel value) {
		companyDao.update(companyTransformer.modelToEntity(value));
	}

	@Override
	public void delete(int id) {
		companyDao.delete(companyDao.byId(id));
	}

	@Override
	public List<CompanyModel> getList(String namedQery) {
		List<CompanyModel> result = new ArrayList<>();
		for (Company company: companyDao.byList(namedQery)){
			result.add(companyTransformer.entityToModel(company));
		}
		return result;
	}

	@Override
	public CompanyModel getId(int id) {
		return companyTransformer.entityToModel(companyDao.byId(id));
	}

}
