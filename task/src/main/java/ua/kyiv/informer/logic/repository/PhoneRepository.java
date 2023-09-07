package ua.kyiv.informer.logic.repository;

import java.util.List;

import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.kyiv.informer.logic.entity.Phone;

@Repository("phoneDao")
public class PhoneRepository extends MainDao<Phone>{


	@Override
	public Phone byId(int id) {
		return em.find(Phone.class, id);
	}

	@Override
	public List<Phone> byList(String namedQuery) {
		TypedQuery<Phone> listPhone = em.createNamedQuery("allPhone", Phone.class);
		return listPhone.getResultList();
	}

    public boolean checkUniqueNumberPhone(String numberPhone) {
		em.find(Phone.class, numberPhone);
		return  em.createNamedQuery("phone.checkUniqueNumber", Phone.class)
				.setParameter("phoneNumber", numberPhone)
				.getResultList().isEmpty();
    }
}
