package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.IndisponibiliteException;

public interface IReanimation {

	void reanimer(Patient patient) throws IndisponibiliteException;
}
