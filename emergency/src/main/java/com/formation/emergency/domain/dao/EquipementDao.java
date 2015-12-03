package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.formation.emergency.domain.pojo.Equipement;

@Repository("equipementDao")
public class EquipementDao implements IRepository<Equipement> {

	Map<String, Equipement> equipements = new HashMap<String, Equipement>();

	@Override
	public void create(Equipement equipement) {
		//equipements.put(equipement.getReference(), equipement);
	}

	@Override
	public Equipement read(Object key) {
		return equipements.get(key);
	}

	@Override
	public void update(Equipement equipement) {
		//equipements.put(equipement.getReference(), equipement);
	}

	@Override
	public void delete(Object key) {
		if(equipements.containsKey(key))
		{
			equipements.remove(key);
		}
	}
	
	

}
