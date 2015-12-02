package com.formation.emergency.domain.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.formation.emergency.domain.pojo.Equipement;

@Repository("equipementDao")
public class EquipementDao implements IDao<Equipement> {
			
	private Map<String,Equipement> equipements;
		
	public EquipementDao() {
		super();
		this.equipements = new HashMap<String,Equipement>();
	}

	@Override
	public void create(Equipement item) {	
		String uuid = UUID.randomUUID().toString();		
		item.setReference(uuid);		
		this.equipements.put(uuid,item);		
		System.out.println("Creation de l'equipement : " + uuid + " - " + item.toString());
	}
	
	@Override
	public Equipement find(Object key) {
		return this.equipements.get(key);
	}
	
	@Override
	public void update(Equipement item) {
		this.equipements.put(item.getReference(), item);
		System.out.println("Mise à jour de l'equipement : " + item.getReference()  + " - "+ item.toString());
	}

	@Override
	public void delete(Object key) {
		this.equipements.remove(key);
		System.out.println("Suppression de l'equipement : " + key);
	}


}
