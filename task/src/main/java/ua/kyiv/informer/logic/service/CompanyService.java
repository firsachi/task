package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.Set;

import ua.kyiv.informer.ui.company.CompanyModel;

public interface CompanyService {

	List<CompanyModel> all(String string);

	void save(CompanyModel model);

	CompanyModel byId(int id);

	 void update(CompanyModel model);

	boolean findQnique(CompanyModel model);

	void delete(CompanyModel companyModel);

	Set<CompanyModel> all(boolean b);

}
