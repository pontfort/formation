package com.formation.emergency.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.IDao;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;


@Service("logistique")
public class Logistique implements ILogistique {

	@Autowired
	@Qualifier("equipementDao")	
	private IDao<Equipement> dao;
	
	@Override
	public void acheter(Equipement item) throws IndisponibiliteException {
		dao.create(item);		
	}

	@Override
	public void reparer(Equipement item) throws IndisponibiliteException {		
		item.setEtat(EtatEquipement.FONCTIONNE);
		dao.update(item);
	}

	@Override
	public void retirer(Equipement item) throws IndisponibiliteException {
		dao.delete(item.getReference());		
	}

	@Override
	public Equipement mettreADisposition(String reference) throws IndisponibiliteException {
		Equipement item = dao.find(reference);
		if (item.isReserve()) {
			throw new IndisponibiliteException(Indisponibilite.RESERVE,"Cet equipement est déjà reservé");
		} else if (item.getEtat() == EtatEquipement.CASSE) {
			throw new IndisponibiliteException(Indisponibilite.IRREPARABLE,"Cet equipement est cassé");
		}
		item.setReserve(true);
		return item;
	}

	@Override
	public void recuperer(Equipement item) throws IndisponibiliteException {
		item.setReserve(false);
		dao.update(item);
	}

	public IDao<Equipement> getDao() {
		return dao;
	}

	public void setDao(IDao<Equipement> dao) {
		this.dao = dao;
	}

}
