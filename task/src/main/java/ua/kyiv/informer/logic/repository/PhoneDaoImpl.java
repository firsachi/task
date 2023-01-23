package ua.kyiv.informer.logic.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.kyiv.informer.logic.entity.Phone;

@Repository("phoneDao")
public class PhoneDaoImpl extends MainDao<Phone>{


	@Override
	public Phone byId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> byList(String namedQery) {
		TypedQuery<Phone> listPhone = em.createNamedQuery("allPhone", Phone.class);
		return listPhone.getResultList();
	}

}
