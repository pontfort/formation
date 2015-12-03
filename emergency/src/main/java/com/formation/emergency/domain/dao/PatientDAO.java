package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.coordonnees.Patient;
import com.formation.emergency.domain.pojo.equipement.Equipement;

public class PatientDAO extends DaoJpa implements IRepository<Patient> {

	private Map<String, Patient> patients;

	@Override
	public void create(Object object) {
		getPatients().put(((Patient) object).getUID(), (Patient) object);
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


	@Override
	public List<Equipement> findByStemming(Date min, Date max, EtatEquipement etat, String pays, String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

}
