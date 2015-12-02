package com.formation.emergency.business;

import java.util.SortedSet;

import com.formation.emergency.domain.pojo.coordonnees.Patient;
import com.formation.emergency.exception.IndisponibiliteException;

public interface IMaternite extends IAccueil, IConsultation {

	public SortedSet<Patient> accoucher(Patient patient) throws IndisponibiliteException;

	
}
