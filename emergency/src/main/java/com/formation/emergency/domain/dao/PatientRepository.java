package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.Map;

import com.formation.emergency.domain.pojo.Patient;

public class PatientRepository implements IRepository<Patient> {
	
	Map<String, Patient> listePatient = new HashMap<String, Patient>();

	@Override
	public void create(Patient object) {
		// TODO Auto-generated method stub
		listePatient.put(object.getNumeroSecu(), object);
	}

	@Override
	public Patient read(Object key) {
		// TODO Auto-generated method stub
		return listePatient.get(key);
	}

	@Override
	public void update(Patient object) {
		// TODO Auto-generated method stub
		listePatient.put(object.getNumeroSecu(), object);
	}

	@Override
	public void delete(Object key) {
		// TODO Auto-generated method stub
		listePatient.remove(key);
	}

	
}
