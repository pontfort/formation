package com.formation.emergency.business.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.IRepository;
import com.formation.emergency.domain.dao.IRepositoryGenric;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.constante.IQueryConstante;
import com.formation.emergency.domain.pojo.equipement.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;

@Service("logistique")
public class Logistique implements ILogistique {

	private IRepository<Equipement> logistiqueDao;

	@Override
	public void acheter(Equipement equipement) throws IndisponibiliteException {
		if (equipement == null)
			throw new IndisponibiliteException(Indisponibilite.VOLE, "L'equipement n'existe pas !");

		if (equipement.getId() != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(IQueryConstante.PARAM_ETAT, equipement.getEtat());
			params.put(IQueryConstante.PARAM_TYPE, equipement.getType());
			params.put(IQueryConstante.PARAM_ID, equipement.getId());
			((IRepositoryGenric) logistiqueDao).executeQuery(IQueryConstante.EQUIPEMENT_UPDATE, params);
		} else
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

	@Override
	public List<Equipement> findByStemming(Date min, Date max, EtatEquipement etat, String pays, String chaine) {
		return logistiqueDao.findByStemming(min, max, etat, pays, chaine);
	}

}
