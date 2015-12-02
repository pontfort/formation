package com.formation.emergency.business.impl;

import com.formation.emergency.business.IAmbulancier;
import com.formation.emergency.domain.pojo.Adresse;
import com.formation.emergency.domain.pojo.Ambulance;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.IndisponibiliteExpection;;

public class Ambulancier implements IAmbulancier {

	@Override
	public boolean transporter(Ambulance ambulance, Patient patient, Adresse depart, Adresse arrivee)
			throws IndisponibiliteException {
		// TODO Auto-generated method stub
		return false;
	}



}
