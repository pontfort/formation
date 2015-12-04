package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.formation.emergency.domain.pojo.Equipement;

public class EquipementJpa extends GenericRepository implements IRepository<Equipement>, IGenericRepository {

	@Override
	public Equipement read(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Equipement object) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(QueriesDictonary.EQUIPEMENT_ID, object.getId());
		parameters.put(QueriesDictonary.EQUIPEMENT_DISPONIBLE, object.isDisponible());
		executeQuery(QueriesDictonary.EQUIPEMENT_UPDATE_DISPONIBLE, parameters);
	}

	@Override
	public void delete(Object key) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(QueriesDictonary.EQUIPEMENT_ID, key);
		executeQuery(QueriesDictonary.EQUIPEMENT_DELETE, parameters);
	}

	@Override
	public List<Equipement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Object object) {
		super.create(object);
	}
	
}
