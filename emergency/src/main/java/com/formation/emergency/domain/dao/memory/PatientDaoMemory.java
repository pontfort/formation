package com.formation.emergency.domain.dao.memory;

import java.util.HashMap;
import java.util.Map;

import com.formation.emergency.domain.dao.IDao;
import com.formation.emergency.domain.pojo.Patient;

public class PatientDaoMemory implements IDao<Patient> {
	
	private Map<Integer,Patient> patients;
		
	public PatientDaoMemory() {
		super();
		this.patients = new HashMap<Integer,Patient>();
	}

	@Override
	public void create(Object item) {
		Patient pat = (Patient)item;		
		Integer newID = this.patients.size();
		pat.setId(newID);
		this.patients.put(newID,pat);		
		System.out.println("Creation de l'equipement : " + newID + " - " + pat.toString());
	}
	
		
	@Override
	public Patient find(Object key) {
		return this.patients.get(key);
	}
	
	@Override
	public void update(Patient item) {
		this.patients.put(item.getId(), item);
		System.out.println("Mise à jour du patient : " + item.getUuid()  + " - " + item.getNom() + " " + item.getPrenom());
	}

	@Override
	public void delete(Object key) {
		this.patients.remove(key);
		System.out.println("Suppression du patient : " + key);
	}

}
