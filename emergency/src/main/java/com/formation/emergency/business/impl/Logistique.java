package com.formation.emergency.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.daoSpringRepo.IEquipementJPA;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;

@Transactional
public class Logistique implements ILogistique {

	private IRepository<Equipement> logistiqueDao;
	
	@Autowired
	private  IEquipementJPA equipementJPA;

	@Override
	public void acheter(Equipement equipement) throws IndisponibiliteException {
		//logistiqueDao.create(equipement);
		this.equipementJPA.saveAndFlush(equipement);
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

	@Override
	public List<Equipement> getbyCriteria(String sarting, String containing, String ending, Date dateachat, int prixmin,
			int prixmax) {

		return this.equipementJPA.findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullAndDateAchatAfterAndPrixBetweenOrderByPrix(sarting, containing, ending, dateachat, prixmin, prixmax);
	}

}
