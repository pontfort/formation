package com.formation.emergency.domain.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.formation.emergency.domain.pojo.Patient;

public class PatientJpa extends GenericRepository implements IRepository<Patient>, IGenericRepository {

	@Override
	public Patient read(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Patient object) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(QueriesDictonary.PATIENT_ID, object.getId());
		parameters.put(QueriesDictonary.PATIENT_ETAT, object.getEtat());
		executeQuery(QueriesDictonary.PATIENT_UPDATE_ETAT, parameters);
	}

	@Override
	public void delete(Object key) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(QueriesDictonary.PATIENT_ID, key);
		executeQuery(QueriesDictonary.PATIENT_DELETE, parameters);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Object object) {
		super.create(object);
	}
	
}
