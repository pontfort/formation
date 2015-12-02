package com.formation.emergency.business.impl;

import java.util.SortedSet;

import com.formation.emergency.business.IMaternite;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.IndisponibiliteExpection;
import com.formation.emergency.exception.RechercheException;

public class Maternite implements IMaternite {

	@Override
	public boolean receptionner(Patient patient) throws RechercheException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FeuilleSortie sortie(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeuilleSortie diagnostiquer(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Patient> accoucher(Patient patient) throws IndisponibiliteException {
		// TODO Auto-generated method stub
		return null;
	}



}
