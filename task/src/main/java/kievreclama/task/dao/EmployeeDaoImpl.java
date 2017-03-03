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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee byId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Employee> listEmloyee = session.createNamedQuery(namedQery, Employee.class);
		return listEmloyee.getResultList();
	}

}
