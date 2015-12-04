package com.formation.emergency.domain.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.SelectorPredicate;

public class EquipementSelector implements IEquipementSelector {

	@PersistenceContext
	protected EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Equipement> findByCriteria(Date dateMin, Date dateMax, String pays, String ref) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Equipement> criteria = builder.createQuery(Equipement.class);
		Root<Equipement> root = criteria.from(Equipement.class);
		criteria.select(root);
		criteria.distinct(true);
		TypedQuery<Equipement> query = em.createQuery(criteria);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (dateMin != null) {
			predicates.add(builder.greaterThan(root.<Date> get("dateAchat"), dateMin));
		}

		if (dateMax != null) {
			predicates.add(builder.lessThan(root.<Date> get("dateAchat"), dateMax));
		}
		criteria.select(root);
		for (Predicate predicate : predicates) {
			criteria.where(predicate);
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipement> findByCriteriaAndStringBuilder(List<SelectorPredicate> selector) throws Exception {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("SELECT e FROM Equipement e where 1=1 ");

		for (SelectorPredicate selectorPredicate : selector) {

			stringBuilder.append(" AND ");
			stringBuilder.append(selectorPredicate.getKey());

			switch (selectorPredicate.getOperator()) {
			case EQUAL:
				stringBuilder.append(" = ");
				break;
			case GREATERTHAN:
				stringBuilder.append(" > ");
				break;
			case LESSTHAN:
				stringBuilder.append(" < ");
				break;
			case NOTEQUAL:
				stringBuilder.append(" <> ");
				break;
			case LIKE:
				stringBuilder.append(" LIKE ");
				break;
			case STEMING:
				stringBuilder.append("  ");
				break;
			default:
				throw new Exception("");
			}
			stringBuilder.append("'");
			stringBuilder.append(selectorPredicate.getValue());
			stringBuilder.append("'");			
		}
		
		String query = stringBuilder.toString();
		System.out.println(query.toString());
		List<Equipement>eqs= (List<Equipement>) em.createQuery(query).getResultList();
		return eqs;
	}

}
