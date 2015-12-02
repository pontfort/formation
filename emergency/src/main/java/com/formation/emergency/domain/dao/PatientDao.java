package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.Map;

import com.formation.emergency.domain.pojo.Patient;

public class PatientDao implements IRepository<Patient> {

	Map<String, Patient> patients = new HashMap<String, Patient>();
	
	@Override
	public void create(Patient patient) {
		patients.put(patient.getNumeroSecu(), patient);
	}

	@Override
	public Patient read(Object key) {
		return patients.get(key);
	}

	@Override
	public void update(Patient patient) {	
		patients.put(patient.getNumeroSecu(), patient);
	}

	@Override
	public void delete(Object key) {
		if(patients.containsKey(key))
		{
			patients.remove(key);
		}
	}
}
