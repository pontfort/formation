package com.formation.emergency.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.repository.IDao;
import com.formation.emergency.domain.dao.repository.IGenericDao;
import com.formation.emergency.domain.dao.springrepo.IPatientJPA;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.feuilles.ActeDeces;
import com.formation.emergency.domain.pojo.feuilles.Consultation;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;
import com.formation.emergency.domain.pojo.feuilles.Ordonnance;
import com.formation.emergency.exception.RechercheException;

@Transactional
public class Accueil implements IAccueil {

	private IDao<Patient> dao;

	@Autowired
	private IPatientJPA patientRepo;

	@Override
	public boolean receptionner(Patient patient) throws Exception {
		if (patient == null) {
			throw new RechercheException();
		}
		// this.dao.create(patient);
		this.patientRepo.saveAndFlush(patient);
		return true;
	}

	public void enregistrer(Patient patient) throws Exception {
		if (patient.getId() == null) {
			this.dao.create(patient);
		} else {
			if (this.dao instanceof IGenericDao) {
				patientRepo.updateEtat(patient.getEtat(), patient.getId());
			} else {
				this.dao.update(patient);
			}
		}
	}

	@Override
	public FeuilleSortie sortie(Patient patient) throws Exception {

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

		this.dao.delete(patient.getId());

		return feuille;
	}

	public IDao<Patient> getDao() {
		return dao;
	}

	public void setDao(IDao<Patient> dao) {
		this.dao = dao;
	}

}
