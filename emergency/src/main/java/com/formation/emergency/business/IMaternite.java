package com.formation.emergency.business;

import java.util.SortedSet;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.IndisponibiliteException;

public interface IMaternite extends IAccueil, IConsultation {
	
	SortedSet<Patient> accoucher(Patient patient) throws IndisponibiliteException;
}
