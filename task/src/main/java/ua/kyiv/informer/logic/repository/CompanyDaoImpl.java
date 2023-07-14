package ua.kyiv.informer.logic.repository;

import java.util.List;

import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.kyiv.informer.logic.entity.Company;

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

	public boolean existsByCompanyName(int id, String nameCompany) {
		return em.createNamedQuery("uniqieNameCompany", Company.class).setParameter("id", id).setParameter("nameCompany", nameCompany).getResultList().isEmpty();
	}

	@Override
	public void add(Company entity) {
		em.persist(entity);
	}

	public List<Company> byList(boolean disable) {
		return em.createNamedQuery("isDisabelList", Company.class).setParameter("disable", disable).getResultList();
	}

}
