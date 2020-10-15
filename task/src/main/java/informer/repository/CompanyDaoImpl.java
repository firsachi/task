package informer.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import informer.entity.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends MainDao<Company>{
	
	@Override
	public Company byId(int id) {
		return em.find(Company.class, id);
	}

	@Override
	@Transactional
	public List<Company> byList(String namedQery) {
		TypedQuery<Company> typedQuery = em.createNamedQuery(namedQery, Company.class);
		return typedQuery.getResultList();
	}

}
