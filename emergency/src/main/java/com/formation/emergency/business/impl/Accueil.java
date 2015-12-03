package com.formation.emergency.business.impl;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.pojo.ActeDeces;
import com.formation.emergency.domain.pojo.ActeNaissance;
import com.formation.emergency.domain.pojo.Consultation;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Ordonnance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;

public class Accueil implements IAccueil {

	private IRepository<Patient> patientDao;
	
	@Override
	public boolean receptionner(Patient patient) throws RechercheException {

		if(patient == null || patient.getNumeroSecu() == null)
		{
			throw new RechercheException();
		}
		
		patientDao.create(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) {
		FeuilleSortie f=null;
			switch (patient.getEtatPatient()) {
			case SORTIE_DEFINITIVE:
				patientDao.delete(patient.getNumeroSecu());
				f= new Ordonnance();
				break;
			case MORT:
				patientDao.delete(patient.getNumeroSecu());
				f= new ActeDeces();
				break;
			case NAISSANCE:
				patientDao.update(patient);
				f= new ActeNaissance();
				break;
			default:
				f= new Consultation();
				break;
			}
		
		return f;
	}
	 
	private void Paiement(String numeroSecu){
		//TODO Paiement du patient
	}

	public IRepository<Patient> getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(IRepository<Patient> patientDao) {
		this.patientDao = patientDao;
	}

}
