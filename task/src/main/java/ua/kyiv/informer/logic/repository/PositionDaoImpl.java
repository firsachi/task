package ua.kyiv.informer.logic.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ua.kyiv.informer.logic.entity.Position;

@Repository("postDao")
public class PositionDaoImpl extends MainDao<Position>{

	@Override
	public Position byId(int id) {
		return em.find(Position.class, id);
	}

	@Override
	public List<Position> byList(String nameQuery) {
		return em.createNamedQuery(nameQuery, Position.class).getResultList();
	}

	public boolean isUnique(Position position){
		return !em.createNamedQuery("position.isUnique", Position.class)
				.setParameter("id", position.getId())
				.setParameter("namePosition", position.getNamePosition())
				.getResultList().isEmpty();
	}

    public Position findNamePosition(String namePosition) {
		return em.createNamedQuery("position.findNamePosition", Position.class)
				.setParameter("namePosition", namePosition).getSingleResult();
    }
}