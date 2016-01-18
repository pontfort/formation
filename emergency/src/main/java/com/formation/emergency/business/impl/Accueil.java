package com.formation.emergency.business.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.repository.IDao;
import com.formation.emergency.domain.dao.repository.IGenericDao;
import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.dao.springrepository.IPatientSpringJPA;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.code.EtatPatient;
import com.formation.emergency.domain.pojo.feuilles.ActeDeces;
import com.formation.emergency.domain.pojo.feuilles.Consultation;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;
import com.formation.emergency.domain.pojo.feuilles.Ordonnance;
import com.formation.emergency.exception.RechercheException;

@Transactional
public class Accueil implements IAccueil {	
	
	/**
	 * Manuel repository
	 */
	private IDao<Patient> dao;
	
	/**
	 * Spring repository 
	 */	
	@Autowired private IPatientSpringJPA patientRepo;
	
	@Override
	public boolean receptionner(Patient patient) throws Exception {
		if (patient == null) {
			throw new RechercheException();
		}
		// DAO manuel
		// this.dao.create(patient);
		// DAO - spring-data
		this.patientRepo.saveAndFlush(patient);
		this.patientRepo.updateEtat(EtatPatient.MORT, patient.getId());
		return true;
	}
	
	public void enregistrerEtat(Patient patient) throws Exception {
		if (patient.getId() == null) {
			this.patientRepo.saveAndFlush(patient);
		} else {
			this.patientRepo.updateEtat(patient.getEtat(), patient.getId());					
		}							
	}
	
//	Manuel DAO	
//	public void enregistrerEtat(Patient patient) throws Exception {
//		if (patient.getId() == null) {
//			this.dao.create(patient);
//		} else {
//			if (this.dao instanceof IGenericDao) {
//				//Creation de la map d'attribut
//				Map<String, Object> params = new HashMap<String, Object>();
//				params.put(QueriesDictionary.PATIENT_QUERY_PARAM_ID, patient.getId());
//				params.put(QueriesDictionary.PATIENT_QUERY_PARAM_ETAT, patient.getEtat());			
//				((IGenericDao) this.dao).executeQuery(QueriesDictionary.PATIENT_UPDATE_ETAT, params);
//			} else {
//				this.dao.update(patient);
//			}			
//		}							
//	}
	
	public void enregistrer(Patient patient) throws Exception {
		if (patient.getId() == null) {
			this.dao.create(patient);
		} else {
			if (this.dao instanceof IGenericDao) {
				//Creation de la map d'attribut
				Map<String, Object> params = new HashMap<String, Object>();
				params.put(QueriesDictionary.PATIENT_QUERY_PARAM_ID, patient.getId());
				params.put(QueriesDictionary.PATIENT_QUERY_PARAM_NOM, patient.getNom());
				params.put(QueriesDictionary.PATIENT_QUERY_PARAM_PRENOM, patient.getPrenom());
				params.put(QueriesDictionary.PATIENT_QUERY_PARAM_SECU, patient.getNumeroSECU());			
				params.put(QueriesDictionary.PATIENT_QUERY_PARAM_ETAT, patient.getEtat());
				((IGenericDao) this.dao).executeQuery(QueriesDictionary.PATIENT_UPDATE, params);
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
