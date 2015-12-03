package com.formation.emergency.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.formation.emergency.domain.pojo.Equipement;

public class LogitiqueDaoJpa extends GenericRepository implements IRepository<Equipement> {

	public void create(Equipement object) {
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
	}

	@Override
	public void update(Equipement object) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Object object) {
		EntityManager em = this.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Query q = em.createNamedQuery(QueriesDictionary.EQUIPEMENT_DELETE);
			q.setParameter(QueriesDictionary.EQUIPEMENT_QUERYPARAM_ID, object);
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.toString());
		}
	}

	@Override
	public Equipement find(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipement> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
