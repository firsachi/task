package kievreclama.task.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.dao.MainDao;
import kievreclama.task.entity.Company;

public class CompanyDaoImpl extends MainDao<Company>{

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createNamedQuery("deleteCompany").setParameter("id", id).executeUpdate();
	}
	
	@Override
	public Company byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Company.class, id);
	}

	@Override
	@Transactional
	public List<Company> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Company> typedQuery = session.createNamedQuery(namedQery, Company.class);
		return typedQuery.getResultList();
	}

}
