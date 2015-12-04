package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

public interface IAccueil {
	
	boolean receptionner(Patient patient) throws Exception;
	
	void enregistrer(Patient patient) throws Exception;
	
	FeuilleSortie sortie(Patient patient) throws Exception;
	
}
