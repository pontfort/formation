package com.formation.emergency.domain.dao;

import javax.persistence.Query;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.formation.emergency.domain.pojo.Patient;

public class PatientDaoJpa extends GenericRepository implements IRepository<Patient> {

	public PatientDaoJpa() {
		super();
	}

	@Override
	public Patient read(Object key) {
		return this.getEm().find(Patient.class, key);
	}

	@Override
	public void update(Patient patient) {

		Query query = this.getEm().createNamedQuery(QueriesDictionary.PATIENT_UPDATE_ETAT);

		// Query query = em.createQuery("Update Patient p SET p.nom :pNom where
		// p.id= :pId");

		query.setParameter(QueriesDictionary.PATIENT_PARAM_ETAT_PATIENT, patient.getEtatPatient());
		query.setParameter(QueriesDictionary.PARAM_ID, patient.getId());
		query.executeUpdate();

	}

	@Override
	public void delete(Object key) {
		Query query = this.getEm().createNamedQuery(QueriesDictionary.PATIENT_DELETE);
		// Query query = em.createQuery("Delete FROM Patient p where
		// p.numeroSecu='" + key + "'");
		query.setParameter(QueriesDictionary.PATIENT_PARAM_NUMERO_SECU, key);
		System.out.println(query.toString());
		query.executeUpdate();
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
