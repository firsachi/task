package kievreclama.task.model.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kievreclama.task.entity.Phone;
import kievreclama.task.model.dao.PhoneDao;

@Repository
public class PhoneDaoImpl implements PhoneDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public Set<Phone> getAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Phone> phones = session.createNamedQuery("allPhone", Phone.class);
		return new HashSet<Phone>(phones.getResultList());
	}

	@Override
	public void add(Phone phone) {
		Session session = sessionFactory.getCurrentSession();
		session.save(phone);
	}

	@Override
	public void upadte(Phone phone) {
		Session session = sessionFactory.getCurrentSession();
		session.update(phone);
	}

	@Override
	public Phone byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Phone.class, id);
	}

}
