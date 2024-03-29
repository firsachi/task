/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.informer.logic.repository;

import java.util.List;

import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.kyiv.informer.logic.entity.Department;

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


	public List<Department> byList(String string, int idCompany) {
		return em.createNamedQuery(string, Department.class).setParameter("idCompany", idCompany).getResultList();
	}

	public boolean isUnique(Department department) {
		return !em.createNamedQuery("isUniqueName" , Department.class)
				.setParameter("id", department.getId())
				.setParameter("name", department.getName())
				.getResultList().isEmpty();
	}

    public Department findNameDepartment(String departmentName) {
		return em.createNamedQuery("searchDepartmentExists", Department.class)
				.setParameter("departmentName", departmentName).getSingleResult();
    }
}
