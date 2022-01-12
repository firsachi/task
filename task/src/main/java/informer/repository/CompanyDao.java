package informer.repository;

import javax.validation.ConstraintDefinitionException;

import org.springframework.orm.jpa.JpaSystemException;

import informer.entity.Company;

public interface CompanyDao {
	
	void add(Company entity) throws JpaSystemException, ConstraintDefinitionException;

}
