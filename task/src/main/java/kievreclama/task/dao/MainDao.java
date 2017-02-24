package kievreclama.task.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class MainDao<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	public void insert(T value){
		Session session = sessionFactory.getCurrentSession();
		session.save(value);
	}
	
	public void update(T value){
		Session session = sessionFactory.getCurrentSession();
		session.update(value);
	}
	
	public abstract void delete(int id);
	public abstract T byId(int id);
	public abstract List<T> byList(String namedQery);
}
