package ua.kyiv.informer.logic.repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.kyiv.informer.logic.entity.HrOrder;

@Repository
public class HrOrderRepository extends MainDao<HrOrder>{

	@Override
	public HrOrder byId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HrOrder> byList(String namedQery) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<HrOrder> findAll() {
		return em.createNamedQuery("HrOrder.listAll", HrOrder.class).getResultList();
	}

}
