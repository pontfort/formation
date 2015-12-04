package com.formation.emergency.business.impl;

import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;

@Transactional
public class Logistique implements ILogistique {

	private IRepository<Equipement> logistiqueDao;

	@Override
	public void acheter(Equipement equipement) throws IndisponibiliteException {
		logistiqueDao.create(equipement);
	}

	@Override
	public void reparer(Equipement equipement) throws IndisponibiliteException {
		if (equipement.getEtat() != EtatEquipement.CASSE)
			throw new IndisponibiliteException(Indisponibilite.IRREPARABLE, "Irreparable");
		logistiqueDao.update(equipement);
	}

	@Override
	public void retirer(Equipement equipement) throws IndisponibiliteException {
		logistiqueDao.delete(equipement.getId());
	}

	@Override
	public Equipement mettreADisposition(Object refEquipement) throws IndisponibiliteException {
		return logistiqueDao.find(refEquipement);
	}

	@Override
	public void recuperer(Equipement equipement) throws IndisponibiliteException {
		logistiqueDao.update(equipement);
	}

	public IRepository<Equipement> getLogistiqueDao() {
		return logistiqueDao;
	}

	public void setLogistiqueDao(IRepository<Equipement> logistiqueDao) {
		this.logistiqueDao = logistiqueDao;
	}

}
