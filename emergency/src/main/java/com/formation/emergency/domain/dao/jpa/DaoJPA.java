package com.formation.emergency.domain.dao.jpa;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.formation.emergency.domain.dao.IGenericDao;

public class DaoJPA implements IGenericDao {

	@PersistenceContext
	private EntityManager em;

	public void create(Object item) {
		em.persist(item);

	}

	@Override
	public List<?> executeQuery(String nameQuery, Map<String, Object> params) {

		List<?> list = null;

		Query query = em.createNamedQuery(nameQuery);

		for (Entry<String, Object> item : params.entrySet()) {
			query.setParameter(item.getKey(), item.getValue());
		}

		if (nameQuery.contains("find")) {
			list = query.getResultList();
		} else {
			query.executeUpdate();
		}

		return list;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
