package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.Map;

import com.formation.emergency.domain.pojo.Patient;

public class PatientDao implements IDao<Patient> {

	Map<String, Patient> patients = new HashMap<String, Patient>();
	
	@Override
	public void create(Patient patient) {
		// TODO Auto-generated method stub
		patients.put(patient.getNumeroSecu(), patient);
	}

	@Override
	public Patient read(Object key) {
		// TODO Auto-generated method stub
		return patients.get(key);
	}

	@Override
	public void update(Patient patient) {
		// TODO Auto-generated method stub
		//patient.get() = patient;
	}

	@Override
	public void delete(Object key) {
		// TODO Auto-generated method stub
		if(patients.containsKey(key))
		{
			patients.remove(key);
		}
	}
}
