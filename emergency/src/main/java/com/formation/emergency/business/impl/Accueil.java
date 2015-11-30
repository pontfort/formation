package com.formation.emergency.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.pojo.ActeDeces;
import com.formation.emergency.domain.pojo.Consultation;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Ordonnance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;

public class Accueil implements IAccueil {
	
	private List<Patient> patients = new ArrayList<Patient>();

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		if(patients.size() > 20){
			return false;
		}
		patients.add(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) {
		switch(patient.getEtat()){
		case MORT:
			patients.remove(patient);
			return new ActeDeces();
		case DOIT_CONSULTER:
			return new Consultation();
		case RENTRE_CHEZ_LUI:
			patients.remove(patient);
			return new Ordonnance();
		default:
			return new Consultation();
		}
	}

}
