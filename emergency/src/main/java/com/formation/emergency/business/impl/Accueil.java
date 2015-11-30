package com.formation.emergency.business.impl;

import java.util.ArrayList;
import java.util.List;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.pojo.ActeDeces;
import com.formation.emergency.domain.pojo.ActeNaissance;
import com.formation.emergency.domain.pojo.Consultation;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Ordonnance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.code.EtatPatient;
import com.formation.emergency.exception.RechercheException;
import com.formation.emergency.exception.code.Recherche;

public class Accueil implements IAccueil {

	private List<Patient> patientsReceptionnes = new ArrayList<Patient>();

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		if (patient == null)
			throw new RechercheException(Recherche.NULL, "Le petient n'existe pas !");
		patientsReceptionnes.add(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) throws RechercheException {
		if (patient == null)
			throw new RechercheException(Recherche.NULL, "Le petient n'existe pas !");
		boolean remove = patientsReceptionnes.remove(patient);

		if (!remove)
			return null;

		FeuilleSortie fs = null;
		if (patient.getEtat() == EtatPatient.CONSULTATION)
			fs = new Consultation();
		else if (patient.getEtat() == EtatPatient.ORDONNANCE)
			fs = new Ordonnance();
		else if (patient.getEtat() == EtatPatient.MORT)
			fs = new ActeDeces();
		else if (patient.getEtat() == EtatPatient.NAISSANCE)
			fs = new ActeNaissance();

		return fs;
	}

	@Override
	public String toString() {
		return String.format("Accueil [toString()=%s, patientsReceptionnes=%s]", super.toString(),
				patientsReceptionnes);
	}

}
