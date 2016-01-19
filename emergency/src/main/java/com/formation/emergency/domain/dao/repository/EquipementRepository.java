package com.formation.emergency.domain.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.formation.emergency.domain.pojo.Equipement;
@Component("daoEquipement")
public class EquipementRepository implements IRepository<Equipement> {

	Map<String, Equipement> listeEquipement = new HashMap<String, Equipement>();
	
	public void create(Object object) {
		// TODO Auto-generated method stub
		listeEquipement.put(((Equipement)object).getReference(), (Equipement)object);
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

	@Override
	public List<Equipement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
