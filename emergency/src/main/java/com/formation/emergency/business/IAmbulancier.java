package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Adresse;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.IndisponibiliteExpection;

public interface IAmbulancier {

	public boolean transporter(Patient patient, Adresse depart, Adresse arrivee) throws IndisponibiliteExpection;
}
