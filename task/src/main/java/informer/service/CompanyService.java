package informer.service;

import java.util.List;

import javax.validation.Valid;

import informer.model.CompanyModel;

public interface CompanyService {

	List<CompanyModel> all(String string);

	void save(CompanyModel model);

	CompanyModel byId(int id);

	 void update(CompanyModel model);

	boolean findQnique(@Valid CompanyModel model);

	void delete(CompanyModel companyModel);

}
