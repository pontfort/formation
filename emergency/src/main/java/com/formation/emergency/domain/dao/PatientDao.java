package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.formation.emergency.domain.pojo.Patient;

public class PatientDao implements IDao<Patient> {
	
	private Map<String,Patient> patients;
		
	public PatientDao() {
		super();
		this.patients = new HashMap<String,Patient>();
	}

	@Override
	public void create(Patient item) {
		String uuid = UUID.randomUUID().toString();		
		item.setUuid(uuid);
		this.patients.put(uuid,item);
		System.out.println("Creation du patient : " + uuid + " - " + item.getNom() + " " + item.getPrenom());
	}
	
	@Override
	public Patient find(Object key) {
		return this.patients.get(key);
	}
	
	@Override
	public void update(Patient item) {
		this.patients.put(item.getUuid(), item);
		System.out.println("Mise à jour du patient : " + item.getUuid()  + " - " + item.getNom() + " " + item.getPrenom());
	}

	@Override
	public void delete(Object key) {
		this.patients.remove(key);
		System.out.println("Suppression du patient : " + key);
	}


}
