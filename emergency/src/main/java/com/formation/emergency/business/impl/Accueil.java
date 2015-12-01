package com.formation.emergency.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.pojo.ActeDeces;
import com.formation.emergency.domain.pojo.Consultation;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Ordonnance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;

public class Accueil implements IAccueil {

	private IRepository<Patient> patientDao;

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		patientDao.create(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) {
		switch (patient.getEtat()) {
		case MORT:
			patientDao.delete(patient);
			return new ActeDeces();
		case DOIT_CONSULTER:
			return new Consultation();
		case RENTRE_CHEZ_LUI:
			patientDao.delete(patient);
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
