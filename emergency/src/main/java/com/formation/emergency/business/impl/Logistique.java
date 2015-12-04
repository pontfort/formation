package com.formation.emergency.business.impl;

import org.springframework.transaction.annotation.Transactional;
import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

@Transactional
public class Logistique implements ILogistique {

	private IRepository<Equipement> equipementDao;
	
	@Override
	public void acheter(Equipement equipement) throws IndisponibiliteException {
		// TODO Auto-generated method stub
		equipementDao.create(equipement);
	}

	@Override
	public void reparer(Equipement equipement) throws Exception {
		// TODO Auto-generated method stub
		equipementDao.update(equipement);
	}

	@Override
	public void retirer(Equipement equipement) throws Exception {
		// TODO Auto-generated method stub
		equipementDao.delete(equipement.getReference());
	}

	@Override
	public Equipement mettreADisposition(String refEquipement) throws Exception {
		// TODO Auto-generated method stub
		Equipement equipement = equipementDao.read(refEquipement);
		equipement.setDisponible(false);
		equipementDao.update(equipement);
		return equipement;
	}

	@Override
	public void recuperer(Equipement equipement) throws Exception {
		// TODO Auto-generated method stub
		equipement.setDisponible(true);
		equipementDao.update(equipement);
	}

	public IRepository<Equipement> getEquipementDao() {
		return equipementDao;
	}

	public void setEquipementDao(IRepository<Equipement> equipementDao) {
		this.equipementDao = equipementDao;
	}

}
