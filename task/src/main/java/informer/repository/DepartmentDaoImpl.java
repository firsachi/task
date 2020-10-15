/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informer.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import informer.entity.Department;

/**
 *
 * @author firsov
 */

@Repository("departmentDao")
public class DepartmentDaoImpl extends MainDao<Department>{

	@Override
	public Department byId(int id) {
		return em.find(Department.class, id);
	}

	@Override
	@Transactional
	public List<Department> byList(String namedQery) {
		TypedQuery<Department> typedQuery = em.createNamedQuery(namedQery, Department.class);
		return typedQuery.getResultList();
	}
    
}
