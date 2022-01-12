package informer.repository;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Repository;

import informer.entity.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends MainDao<Company> implements CompanyDao{
	
	
	@Override
	public Company byId(int id) {
		return em.find(Company.class, id);
	}

	@Override
	public List<Company> byList(String namedQery) {
		TypedQuery<Company> typedQuery = em.createNamedQuery(namedQery, Company.class);
		return typedQuery.getResultList();
	}

	public boolean existsByCompanyName(String nameCompany) {
		return em.createNamedQuery("uniqieNameCompany", Company.class).setParameter("nameCompany", nameCompany).getResultList().isEmpty();
	}

	@Override
	public void add(Company entity) throws PersistenceException, ServiceException {
		em.persist(entity);
	}

}
