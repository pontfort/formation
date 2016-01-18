package com.formation.emergency.domain.dao.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import com.formation.emergency.domain.dao.repository.IDao;
import com.formation.emergency.domain.dao.repository.IDaoEquipement;
import com.formation.emergency.domain.pojo.Equipement;

public class EquipementDaoJPA extends DaoJPA implements IDaoEquipement, IDao<Equipement> {

	public EquipementDaoJPA() {
		super();
	}

	@Override
	public Equipement find(Object key) {
		return (Equipement) this.getEm().find(Equipement.class, key);
	}

	@Override
	public void update(Equipement item) {
		this.getEm().merge(item);
	}

	@Override
	public List<Equipement> find(Date d1, Date d2, Boolean disponible, String paysOrigine,
			int degrePrecisionRecherchePays, String ref) {

		CriteriaBuilder cb = this.getEm().getCriteriaBuilder();

		EntityType<Equipement> equip_ = this.getEm().getMetamodel().entity(Equipement.class);
		CriteriaQuery<Equipement> q = cb.createQuery(Equipement.class);
		Root<Equipement> c = q.from(equip_);

		q = q.select(c);
		q.where(cb.greaterThanOrEqualTo(c.<Date> get("dateAchat"), d1),
				cb.lessThanOrEqualTo(c.<Date> get("dateAchat"), d2));

		TypedQuery<Equipement> query = this.getEm().createQuery(q);

		return query.getResultList();
	}

	@Override
	public List<Equipement> find(List<Predicate> predicates) throws Exception {
	
		StringBuilder builder = new StringBuilder();
		builder.append("FROM Equipement e WHERE 1=1");
		
		int noParam = 0;
		if (predicates != null) {			
			
			for (Predicate predicate : predicates) {
				builder.append(" AND ");				
				switch (predicate.getOperator()) {
				case STEMMING :				
					break;
				default:
					builder.append(predicate.getFieldName()).append(predicate.getOperator().getValue()).append("?");					
				}
				
			}				
		
		}
				
		String queryStr = builder.toString(); 		
		Query query =this.getEm().createQuery(queryStr);
		
		if (predicates != null) {
			noParam = 1;
			for (Predicate predicate : predicates) {
				query.setParameter(noParam++,  predicate.getFieldValue());				
			}				
		
		}
				
		return query.getResultList();
	}

	@Override
	public void delete(Object key) {
		Equipement item = this.find(key);
		this.getEm().remove(item);
	}	

}
