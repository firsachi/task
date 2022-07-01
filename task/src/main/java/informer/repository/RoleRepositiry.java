package informer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import informer.repository.entity.Role;

@Repository
public class RoleRepositiry extends MainDao<Role> {

	@Override
	public Role byId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> byList(String namedQery) {
		return em.createNamedQuery(namedQery, Role.class).getResultList();
	}

}
