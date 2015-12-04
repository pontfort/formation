package com.formation.emergency.domain.dao.memory;

import java.util.HashMap;
import java.util.Map;

import com.formation.emergency.domain.dao.IDao;
import com.formation.emergency.domain.pojo.Equipement;

public class EquipementDaoMemory  implements IDao<Equipement> {
			
	private Map<Integer,Equipement> equipements;
		
	public EquipementDaoMemory() {
		super();
		this.equipements = new HashMap<Integer,Equipement>();
	}

	@Override
	public void create(Object item) {		
		Equipement equip = (Equipement)item;
		Integer newID = this.equipements.size();
		equip.setId(newID);
		this.equipements.put(newID,equip);		
		System.out.println("Creation de l'equipement : " + newID + " - " + equip.toString());
	}
	
	
	@Override
	public Equipement find(Object key) {
		return this.equipements.get(key);
	}
	
	@Override
	public void update(Equipement item) {
		this.equipements.put(item.getId(), item);
		System.out.println("Mise à jour de l'equipement : " + item.getReference()  + " - "+ item.toString());
	}

	@Override
	public void delete(Object key) {
		this.equipements.remove(key);
		System.out.println("Suppression de l'equipement : " + key);
	}
	
}
