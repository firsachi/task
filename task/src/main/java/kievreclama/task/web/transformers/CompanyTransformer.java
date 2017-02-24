package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.Company;
import kievreclama.task.web.models.CompanyModel;

@Component
public class CompanyTransformer {
	

	public Company modelToEntity(CompanyModel companyModel) {
		Company company = new Company();
		company.setId(companyModel.getId());
		company.setName(companyModel.getName());
		company.setRemove(companyModel.getRemove());
		return company;
	}
	
	public CompanyModel entityToModel(Company company){
		CompanyModel companyModel = new CompanyModel();
		companyModel.setId(company.getId());
		companyModel.setName(company.getName());
		companyModel.setRemove(company.getRemove());
		return companyModel;
	}

}
