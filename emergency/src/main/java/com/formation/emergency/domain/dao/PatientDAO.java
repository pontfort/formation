package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.formation.emergency.domain.pojo.coordonnees.Patient;

public class PatientDAO implements IRepository<Patient> {

	private Map<String, Patient> patients;

	@Override
	public void create(Patient object) {
		getPatients().put(object.getUID(), object);
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
		if (patients == null)
			patients = new HashMap<String, Patient>();
		return patients;

	}

}
