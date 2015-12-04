package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;

public class PatientDAOJpa extends GenericRepository implements IRepository<Patient> {

	public void create(Patient object) {
		
		getEm().persist(object.getMere());
		getEm().persist(object.getPere());
		getEm().persist(object);
			
	}
	
	@Override
	public void update(Patient object) {
			// Query q = em.createQuery("UPDATE Patient p SET p.numeroSecu='" +
			// object.getNumeroSecu() + "' WHERE p.id=" + object.getId());
			// Query q = em.createQuery("UPDATE Patient p SET
			// p.numeroSecu=:petat WHERE p.id=:pid");
			Query q = getEm().createNamedQuery(QueriesDictionary.PATIENT_UPDATE_NUMSECU);
			q.setParameter(QueriesDictionary.PATIENT_QUERYPARAM_NUMSECU, object.getNumeroSecu());
			q.setParameter(QueriesDictionary.PATIENT_QUERYPARAM_ID, object.getId());
			q.executeUpdate();
		}

	/**
	 * object = patient.getUID()
	 */
	@Override
	public void delete(Object object) {
			Query q = getEm().createNamedQuery(QueriesDictionary.PATIENT_DELETE);
			q.setParameter(QueriesDictionary.PATIENT_QUERYPARAM_ID, object);
			q.executeUpdate();
		}

	/**
	 * object = patient.getUID()
	 */
	@Override
	public Patient find(Object key) {

		return (Patient) getEm().find(Personne.class, key);
	}

	@Override
	public List<Patient> findall() {
		EntityManager em = getEm();

		return null;
	}


}
