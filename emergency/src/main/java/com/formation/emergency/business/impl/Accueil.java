package com.formation.emergency.business.impl;

import java.util.HashSet;
import java.util.Set;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.pojo.ActeDeces;
import com.formation.emergency.domain.pojo.Consultation;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Ordonnance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;

public class Accueil implements IAccueil {

	private Set<Patient> patients = new HashSet<Patient>();

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		if (patient == null) {
			throw new RechercheException();
		}
		this.patients.add(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) {

		FeuilleSortie feuille = null;

		switch (patient.getEtat()) {
		case MORT:
			feuille = new ActeDeces();
			break;
		case CONSULTATION:
			feuille = new Consultation();
			break;
		case ORDONNANCE:
			feuille = new Ordonnance();
			break;
		}

		this.patients.remove(patient);

		return feuille;
	}

}
