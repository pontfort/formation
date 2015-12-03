package com.formation.emergency.domain.dao;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.emergency.domain.pojo.Patient;

public class PatientDaoJpa implements IRepository<Patient> {

	@Autowired
	private EntityManagerFactory emf;

	public PatientDaoJpa() {
		super();
	}

	@Override
	public void create(Patient patient) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(patient);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			ex.printStackTrace();
		}
	}

	@Override
	public Patient read(Object key) {
		EntityManager em = this.emf.createEntityManager();
		
		return em.find(Patient.class, key);
	}

	@Override
	public void update(Patient patient) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Query query = em.createQuery("Update Patient p SET p.nom :pNom where p.id= :pId");
			query.setParameter("pNom", patient.getNom());
			query.setParameter("pId", patient.getId());
			query.executeUpdate();			
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(Object key) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Query query = em.createQuery("Delete FROM Patient p where p.numeroSecu='" + key + "'");
			query.executeUpdate();		
			
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			ex.printStackTrace();
		}
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
