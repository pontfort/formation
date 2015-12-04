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

import com.formation.emergency.domain.pojo.Equipement;

public class GenericRepository implements IGenericRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<?> ExecuteQuery(String namedQuery, Map<String, Object> parameters) throws Exception {
		List<?> res=null;
			Query q = em.createNamedQuery(namedQuery);
			for (Entry<String, Object> item : parameters.entrySet()) {
				q.setParameter(item.getKey(), item.getValue());
			}

			if (namedQuery.contains("find"))
				res=  q.getResultList();
			else
				q.executeUpdate();
			
				return res;
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/*@Override
	public void create(Object object) {
		EntityManager em = this.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(object);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.toString());
		}	
	}*/
}
