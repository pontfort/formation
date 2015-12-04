package com.formation.emergency.business.impl;

import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.feuilles.ActeDeces;
import com.formation.emergency.domain.pojo.feuilles.Consultation;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;
import com.formation.emergency.domain.pojo.feuilles.Ordonnance;
import com.formation.emergency.exception.RechercheException;

@Transactional
public class Accueil implements IAccueil {

	private IRepository<Patient> patientDao;

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		patientDao.create(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) throws Exception {
		patientDao.update(patient);
		switch (patient.getEtat()) {
		case MORT:
			patientDao.delete(patient.getId());
			return new ActeDeces();
		case DOIT_CONSULTER:
			return new Consultation();
		case RENTRE_CHEZ_LUI:
			patientDao.delete(patient.getId());
			return new Ordonnance();
		default:
			return new Consultation();
		}
	}

	public IRepository<Patient> getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(IRepository<Patient> patientDao) {
		this.patientDao = patientDao;
	}


}
