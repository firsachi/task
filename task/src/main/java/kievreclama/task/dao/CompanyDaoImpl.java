package kievreclama.task.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

import kievreclama.task.entity.Company;

public class CompanyDaoImpl extends MainDao<Company>{

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Company> query = session.createQuery("deleteCompany", Company.class);
		query.setParameter("idCompany", id);
		//query.executeUpdate();
	}
	
	@Override
	public Company byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Company.class, id);
	}

	@Override
	public List<Company> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Company> typedQuery = session.createNamedQuery(namedQery, Company.class);
		return typedQuery.getResultList();
	}

}
