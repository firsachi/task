package informer.old.transformer;

import org.springframework.stereotype.Component;

import informer.entity.Company;
import informer.model.CompanyModel;

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
