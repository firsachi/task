package informer.service;

import java.util.List;

import informer.model.CompanyModel;
import informer.validator.unique.FieldValueExists;

public interface CompanyService extends FieldValueExists {

	List<CompanyModel> all(String string);

	boolean save(CompanyModel model);

	CompanyModel byId(int id);

	void update(CompanyModel model);

}
