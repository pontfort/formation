package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.Patient;

public class PatientDAO implements IRepository<Patient> {

	Map<String,Patient> dataSource= new HashMap<String,Patient>();

	@Override
	public void create(Patient object) {
		// TODO Auto-generated method stub
		this.dataSource.put(((Patient)object).getNumeroSecu(), ((Patient)object));
	}

	@Override
	public void update(Patient object) {
		getPatients().put(object.getUID(), object);
	}

	/**
	 * object = patient.getUID()
	 */
	@Override
	public void delete(Object object) {
		getPatients().remove(object);
	}

	/**
	 * object = patient.getUID()
	 */
	@Override
	public Patient find(Object key) {
		return getPatients().get(key);
	}

	@Override
	public List<Patient> findall() {
		return (List<Patient>) getPatients().values();
	}

	public Map<String, Patient> getPatients() {
		return null;

	}

}
