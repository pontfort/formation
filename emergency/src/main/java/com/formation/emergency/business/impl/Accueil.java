package com.formation.emergency.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IGenericRepository;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.dao.QueriesDictionary;
import com.formation.emergency.domain.pojo.ActeDeces;
import com.formation.emergency.domain.pojo.ActeNaissance;
import com.formation.emergency.domain.pojo.Consultation;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Ordonnance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;

@Service("accueil")
@Transactional
public class Accueil implements IAccueil {

	//@Autowired
	private IRepository<Patient> patientDao;

	@Override
	public boolean receptionner(Patient patient) throws Exception {

		if (patient == null || patient.getNumeroSecu() == null) {
			throw new RechercheException();
		}
		
		Map<String, Object> rechercheParams = new HashMap<String, Object>();
		rechercheParams.put(QueriesDictionary.PATIENT_PARAM_NUMERO_SECU, patient.getNumeroSecu());
		List<Patient> patients = (List<Patient>) ((IGenericRepository) patientDao).executeQuery(QueriesDictionary.PATIENT_SELECT_BY_NUMERO_SECU, rechercheParams);
		if(patients.size() > 0)
		{
			Patient patientByNumeroSecu = patients.get(0);
			if (patientByNumeroSecu.getNumeroSecu().equals(patient.getNumeroSecu())) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put(QueriesDictionary.PATIENT_PARAM_ETAT_PATIENT, patient.getEtatPatient());
				params.put(QueriesDictionary.PATIENT_PARAM_NUMERO_SECU, patient.getNumeroSecu());
				((IGenericRepository) patientDao).executeQuery(QueriesDictionary.PATIENT_UPDATE_ETAT, params);
			} 
		}
		else {
			patientDao.create(patient);
		}
		
		return true;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) throws Exception {
		FeuilleSortie f = null;
		switch (patient.getEtatPatient()) {
		case SORTIE_DEFINITIVE:
			patientDao.delete(patient.getNumeroSecu());
			f = new Ordonnance();
			break;
		case MORT:
			patientDao.delete(patient.getNumeroSecu());
			f = new ActeDeces();
			break;
		case NAISSANCE:

			// patientDao.update(patient);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put(QueriesDictionary.PATIENT_PARAM_ETAT_PATIENT, patient.getEtatPatient());
			params.put(QueriesDictionary.PATIENT_PARAM_NUMERO_SECU, patient.getNumeroSecu());
			((IGenericRepository) patientDao).executeQuery(QueriesDictionary.PATIENT_UPDATE_ETAT, params);
			f = new ActeNaissance();
			break;
		default:
			f = new Consultation();
			break;
		}

		return f;
	}

	public IRepository<Patient> getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(IRepository<Patient> patientDao) {
		this.patientDao = patientDao;
	}

}
