package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;

public interface IAccueil {

	public boolean receptionner(Patient patient) throws RechercheException;
	
}
