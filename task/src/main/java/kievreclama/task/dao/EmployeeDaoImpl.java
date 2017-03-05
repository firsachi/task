package kievreclama.task.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import kievreclama.task.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends MainDao<Employee>{

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createNamedQuery("deleteEmployee").setParameter("id", id).executeUpdate();
	}

	@Override
	public Employee byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employee.class, id);
	}

	@Override
	public List<Employee> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Employee> listEmloyee = session.createNamedQuery(namedQery, Employee.class);
		return listEmloyee.getResultList();
	}

}
