package com.formation.emergency.domain.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository implements IGenericRepository {

	@PersistenceContext
	protected EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<?> executeQuery(String namedQuery, Map<String, Object> parameters) {

		List<?> res = null;
		Query query = em.createNamedQuery(namedQuery);
		for (Entry<String, Object> param : parameters.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		if (namedQuery.contains("select") || namedQuery.contains("find")) {
			res = query.getResultList();
		} else {
			query.executeUpdate();
		}
		return res;
	}

	@Override
	public void create(Object object) {
		em.persist(object);
	}
}
