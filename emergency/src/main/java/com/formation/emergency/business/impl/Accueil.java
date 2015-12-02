package com.formation.emergency.business.impl;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.dao.IDao;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.feuilles.ActeDeces;
import com.formation.emergency.domain.pojo.feuilles.Consultation;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;
import com.formation.emergency.domain.pojo.feuilles.Ordonnance;
import com.formation.emergency.exception.RechercheException;

public class Accueil implements IAccueil {	
	
	private IDao<Patient> dao;
	
	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		if (patient == null) {
			throw new RechercheException();
		}
		this.dao.create(patient);
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

		this.dao.delete(patient.getUuid());

		return feuille;
	}

	public IDao<Patient> getDao() {
		return dao;
	}

	public void setDao(IDao<Patient> dao) {
		this.dao = dao;
	}

}
