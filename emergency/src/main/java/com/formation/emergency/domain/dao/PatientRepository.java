package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.Patient;

public class PatientRepository implements IRepository<Patient> {
	
	Map<String, Patient> listePatient = new HashMap<String, Patient>();

	@Override
	public void create(Object object) {
		// TODO Auto-generated method stub
		listePatient.put(((Patient)object).getNumeroSecu(), (Patient)object);
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

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
