package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;

public interface IConsultation {
	
	FeuilleSortie diagnostiquer(Patient patient);

}
