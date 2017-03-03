package kievreclama.task.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import kievreclama.task.entity.Phone;

public class PhoneDaoImpl extends MainDao<Phone>{

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Phone byId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Phone> listPhone = session.createNamedQuery("allPhone", Phone.class);
		return listPhone.getResultList();
	}

}
