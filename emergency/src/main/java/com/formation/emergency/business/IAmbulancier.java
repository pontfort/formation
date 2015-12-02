package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.coordonnees.Adresse;
import com.formation.emergency.domain.pojo.coordonnees.Patient;
import com.formation.emergency.domain.pojo.equipement.Ambulance;
import com.formation.emergency.exception.IndisponibiliteException;

public interface IAmbulancier {

	public boolean transporter(Ambulance ambulance, Patient patient, Adresse depart, Adresse arrivee)
			throws IndisponibiliteException;

}
