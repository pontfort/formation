package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Adresse;
import com.formation.emergency.domain.pojo.Ambulance;
import com.formation.emergency.domain.pojo.Patient;

public interface IAmbulancier {

	boolean transporter(Ambulance ambulance, Patient patient, Adresse depart, Adresse arrivee)
			throws Exception;
}
