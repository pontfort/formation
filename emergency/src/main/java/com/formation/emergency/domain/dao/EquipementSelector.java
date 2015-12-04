package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.SelectorPredicate;

public class EquipementSelector implements IEquipementSelector {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEmf() {
		return em;
	}

	public void setEmf(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Equipement> findByCriteria(Date dateMin, Date dateMax, boolean disponible, String pays, String ref) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Equipement> q = cb.createQuery(Equipement.class);
		Root<Equipement> c = q.from(Equipement.class);
		
		q = q.select(c);
		if(dateMin != null) q.where(cb.greaterThan(c.<Date> get("dateAchat"), dateMin));
		if(dateMax != null) q.where(cb.lessThan(c.<Date> get("dateAchat"), dateMax));
		q.where(cb.equal(c.<Boolean> get("disponible"), disponible));
		
		TypedQuery<Equipement> query = em.createQuery(q);
		return query.getResultList();
	}
	
	@Override
	public List<Equipement> findByCriteriaAndStringBuilder(List<SelectorPredicate> predicates) throws Exception{
		StringBuilder query = new StringBuilder();
		
		query.append("FROM Equipement e WHERE 1=1 ");
		for (SelectorPredicate predicate : predicates) {
			query.append(" AND ").append(predicate.getKey());
			switch (predicate.getOperator()) {
			case EQUALS:
				query.append(" = ");
				break;
			case NOTEQUALS:
				query.append(" <> ");
				break;
			case GREATERTHAN:
				query.append(" < ");
				break;
			case LOWERTHAN:
				query.append(" > ");
				break;
			case LIKE:
				query.append(" LIKE ");
				break;
				default:
					throw new Exception("Case not Handled" + predicate.getOperator().toString());
			}
			query.append(" '").append(predicate.getValue()).append("' ");
		}
		return em.createQuery(query.toString()).getResultList();
	}

}
