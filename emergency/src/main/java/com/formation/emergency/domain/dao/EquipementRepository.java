package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.Patient;
@Repository("daoEquipement")
public class EquipementRepository implements IRepository<Equipement> {

	Map<String, Equipement> listeEquipement = new HashMap<String, Equipement>();
	
	@Override
	public void create(Equipement object) {
		// TODO Auto-generated method stub
		listeEquipement.put(object.getReference(), object);
	}

	@Override
	public Equipement read(Object key) {
		// TODO Auto-generated method stub
		return listeEquipement.get(key);
	}

	@Override
	public void update(Equipement object) {
		// TODO Auto-generated method stub
		listeEquipement.put(object.getReference(), object);
	}

	@Override
	public void delete(Object key) {
		// TODO Auto-generated method stub
		listeEquipement.remove(key);
	}

}
