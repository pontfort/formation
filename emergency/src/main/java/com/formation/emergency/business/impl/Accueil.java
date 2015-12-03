package com.formation.emergency.business.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.dao.IRepositoryGenric;
import com.formation.emergency.domain.pojo.code.EtatPatient;
import com.formation.emergency.domain.pojo.constante.IQueryConstante;
import com.formation.emergency.domain.pojo.coordonnees.Patient;
import com.formation.emergency.domain.pojo.feuilles.ActeDeces;
import com.formation.emergency.domain.pojo.feuilles.ActeNaissance;
import com.formation.emergency.domain.pojo.feuilles.Consultation;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;
import com.formation.emergency.domain.pojo.feuilles.Ordonnance;
import com.formation.emergency.exception.RechercheException;
import com.formation.emergency.exception.code.Recherche;

public class Accueil implements IAccueil {

	private IRepository<Patient> patientDao;

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		if (patient == null)
			throw new RechercheException(Recherche.NULL, "Le petient n'existe pas !");

		if (patient.getId() != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(IQueryConstante.PARAM_ETAT, patient.getEtat());
			params.put(IQueryConstante.PARAM_NUMEROSECU, patient.getNumeroSecu());
			params.put(IQueryConstante.PARAM_DATENAISSANCE, patient.getDateNaissance());
			params.put(IQueryConstante.PARAM_ID, patient.getId());
			params.put(IQueryConstante.PARAM_NOM, patient.getNom());
			params.put(IQueryConstante.PARAM_PRENOM, patient.getPrenom());
			((IRepositoryGenric) patientDao).executeQuery(IQueryConstante.PATIENT_UPDATE, params);
		} else
			patientDao.create(patient);
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) throws RechercheException {
		if (patient == null)
			throw new RechercheException(Recherche.NULL, "Le petient n'existe pas !");

		EtatPatient etat = patient.getEtat();
		patientDao.delete(patient.getId());

		patient = patientDao.find(patient);

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
