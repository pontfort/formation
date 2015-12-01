package com.formation.emergency.business.impl;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IDao;
import com.formation.emergency.domain.dao.PatientDao;
import com.formation.emergency.domain.pojo.ActeDeces;
import com.formation.emergency.domain.pojo.ActeNaissance;
import com.formation.emergency.domain.pojo.Consultation;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Ordonnance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;

public class Accueil implements IAccueil {

	private IDao<Patient> patients = new PatientDao();
	
	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		// TODO Auto-generated method stub
		
		if(patient == null || patient.getNumeroSecu() == null)
		{
			throw new RechercheException();
		}
		
		patients.create(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) {
		FeuilleSortie f=null;
		
		
			Paiement(patient.getNumeroSecu());
			
			
			switch (patient.getEtatPatient()) {
			case SORTIE_DEFINITIVE:
				patients.delete(patient);
				f= new Ordonnance();
				break;
			case MORT:
				patients.delete(patient);
				f= new ActeDeces();
				break;
			case NAISSANCE:
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

}
