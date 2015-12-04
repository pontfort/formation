package com.formation.emergency.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;

@Service("logistique")
@Transactional
public class Logistique implements ILogistique {

	@Autowired
	@Qualifier("equipementDao")
	private IRepository<Equipement> equipementDao;
	
	@Override
	public void acheter(Equipement equipement) throws Exception {
		equipementDao.create(equipement);
	}

	@Override
	public void reparer(Equipement equipement) throws Exception {

		equipement.setEtatEquipement(EtatEquipement.DISPONIBLE);
		
		equipementDao.update(equipement);
	}

	@Override
	public void retirer(Equipement equipement) throws Exception {
		
		equipementDao.delete(equipement.getReference());
	}

	@Override
	public Equipement mettreADisposition(String refEquipement) throws Exception {
		
		Equipement equipement = equipementDao.read(refEquipement);

		equipement.setEtatEquipement(EtatEquipement.DISPONIBLE);
		
		equipementDao.update(equipement);
		return null;
	}

	@Override
	public void recuperer(Equipement equipement) throws Exception {
		equipement.setEtatEquipement(EtatEquipement.INDISPONIBLE);
		equipementDao.update(equipement);
	}

	public IRepository<Equipement> getEquipementDao() {
		return equipementDao;
	}

	public void setEquipementDao(IRepository<Equipement> equipementDao) {
		this.equipementDao = equipementDao;
	}
}
