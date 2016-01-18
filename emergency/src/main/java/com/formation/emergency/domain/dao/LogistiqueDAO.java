package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.formation.emergency.domain.pojo.Equipement;

@Component("logistiqueDao")
public class LogistiqueDAO implements IRepository<Equipement> {

	private Map<Integer, Equipement> equipements = new HashMap<Integer, Equipement>();

	@Override
	public void create(Equipement object) {
		equipements.put(((Equipement)object).getId(), ((Equipement)object));
	}

	@Override
	public void update(Equipement object) {
		equipements.put(object.getId(), object);
	}

	@Override
	public void delete(Object object) {
		equipements.remove(object);
	}

	@Override
	public Equipement find(Object key) {
		return equipements.get(key);
	}

	@Override
	public List<Equipement> findall() {
		return (List<Equipement>) equipements.values();
	}

}
