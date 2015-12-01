package com.formation.emergency.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IRepository;
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

	@Autowired
	private IRepository<Patient> patientDao;

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		if (patient == null)
			throw new RechercheException(Recherche.NULL, "Le petient n'existe pas !");
		patientDao.create(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) throws RechercheException {
		if (patient == null)
			throw new RechercheException(Recherche.NULL, "Le petient n'existe pas !");

		EtatPatient etat = patient.getEtat();
		patientDao.delete(patient.getUID());

		patient = patientDao.find(patient.getUID());

		// attention il existe tjrs ?!
		if (patient != null)
			throw new RechercheException(Recherche.EXISTE, "Attention le patient n'a pas été supprimé");

		FeuilleSortie fs = null;
		if (etat == EtatPatient.CONSULTATION)
			fs = new Consultation();
		else if (etat == EtatPatient.ORDONNANCE)
			fs = new Ordonnance();
		else if (etat == EtatPatient.MORT)
			fs = new ActeDeces();
		else if (etat == EtatPatient.NAISSANCE)
			fs = new ActeNaissance();

		return fs;
	}

	@Override
	public String toString() {
		return String.format("Accueil [toString()=%s, patientsReceptionnes=%s]", super.toString(),
				patientDao.findall());
	}

	public IRepository<Patient> getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(IRepository<Patient> patientDao) {
		this.patientDao = patientDao;
	}

}
