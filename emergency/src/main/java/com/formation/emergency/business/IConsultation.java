package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.coordonnees.Patient;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

public interface IConsultation {

	public FeuilleSortie diagnostiquer(Patient patient);

}
