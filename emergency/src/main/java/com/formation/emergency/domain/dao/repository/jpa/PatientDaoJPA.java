package com.formation.emergency.domain.dao.repository.jpa;

import javax.persistence.Query;

import com.formation.emergency.domain.dao.repository.IDao;
import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;

public class PatientDaoJPA extends DaoJPA implements IDao<Patient> {

	public PatientDaoJPA() {
		super();
	}

	@Override
	public Patient find(Object key) {
		return (Patient) this.getEm().find(Personne.class, key);
	}

	@Override
	public void update(Patient item) {
		Query query = this.getEm().createNamedQuery(QueriesDictionary.PATIENT_UPDATE_ETAT);
		query.setParameter(QueriesDictionary.PATIENT_QUERY_PARAM_ETAT, item.getEtat());
		query.setParameter(QueriesDictionary.PATIENT_QUERY_PARAM_ID, item.getId());
		query.executeUpdate();
	}

	@Override
	public void delete(Object key) {
		Query query = this.getEm().createNamedQuery("deletePatient");
		query.setParameter("pId", key);
		query.executeUpdate();
	}

}
