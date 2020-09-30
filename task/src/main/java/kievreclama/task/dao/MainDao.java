package kievreclama.task.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public abstract class MainDao<T> {
	
	@PersistenceContext
	protected EntityManager em;
	
	public void insert(T value){
		em.persist(value);
	}
	
	public void update(T value){	
		em.merge(value);
	}
	
	public void delete(T entity) {
		em.remove(entity);
	}
	public abstract T byId(int id);
	public abstract List<T> byList(String namedQery);
}
