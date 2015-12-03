package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.equipement.Equipement;

@Repository("logistiqueDao")
public class LogistiqueDAO extends DaoJpa implements IRepository<Equipement> {

	private Map<Integer, Equipement> equipements = new HashMap<Integer, Equipement>();

	@Override
	public void create(Object object) {
		equipements.put(((Equipement) object).getId(), (Equipement) object);
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

	@Override
	public List<Equipement> findByStemming(Date min, Date max, EtatEquipement etat, String pays, String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

}
