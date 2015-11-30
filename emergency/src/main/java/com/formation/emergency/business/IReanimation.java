package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.IndisponibiliteExpection;

public interface IReanimation {
	public void reanimer(Patient patient) throws IndisponibiliteExpection;
}
