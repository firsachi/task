package informer.service;

import java.util.List;

import javax.validation.Valid;

import informer.model.CompanyModel;
import informer.validator.unique.FieldValueExists;

public interface CompanyService extends FieldValueExists {

	List<CompanyModel> all(String string);

	void save(@Valid CompanyModel model);

}
