package com.formation.emergency.business.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.springrepo.IPatientJPA;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.feuilles.ActeDeces;
import com.formation.emergency.domain.pojo.feuilles.Consultation;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;
import com.formation.emergency.domain.pojo.feuilles.Ordonnance;
import com.formation.emergency.exception.RechercheException;

@Transactional
@WebService(endpointInterface = "com.formation.emergency.business.IAccueil")
public class Accueil implements IAccueil {

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
			this.patientRepo.saveAndFlush(patient);
		} else {
			this.patientRepo.saveAndFlush(patient);
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
		default:
			break;
		}

		this.patientRepo.delete(patient.getId());

		return feuille;
	}

	@Override
	public List<Patient> findAll() throws Exception {
		return patientRepo.findAll();
	}

}
