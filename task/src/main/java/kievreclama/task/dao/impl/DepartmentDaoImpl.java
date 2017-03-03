/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kievreclama.task.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import kievreclama.task.dao.MainDao;
import kievreclama.task.entity.Department;

/**
 *
 * @author firsov
 */

@Repository("departmentDao")
public class DepartmentDaoImpl extends MainDao<Department>{

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createNamedQuery("deleteDepartment").setParameter("id", id).executeUpdate();
	}

	@Override
	public Department byId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Department.class, id);
	}

	@Override
	public List<Department> byList(String namedQery) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Department> typedQuery = session.createNamedQuery(namedQery, Department.class);
		return typedQuery.getResultList();
	}
    
}
