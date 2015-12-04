package com.formation.emergency.domain.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericRepository implements IGenericRepository{

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void create(Object object) {
		em.persist(object);
	}
	
	@Override
	public List<?> executeQuery(String namedQuery, Map<String, Object> parameters) throws Exception{
		List<?> retour = null;
		Query query = em.createNamedQuery(namedQuery);
		for(Entry<String, Object> item : parameters.entrySet()){
			query.setParameter(item.getKey(), item.getValue());
		}
		if(namedQuery.contains("find")){
			retour = query.getResultList();
		}else{
			query.executeUpdate();
		}
		return retour;
	}

}
