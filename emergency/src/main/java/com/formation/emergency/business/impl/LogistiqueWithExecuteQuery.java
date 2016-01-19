package com.formation.emergency.business.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.repository.IDao;
import com.formation.emergency.domain.dao.repository.IGenericDao;
import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;

public class LogistiqueWithExecuteQuery implements ILogistique {

	private IDao<Equipement> dao;

	@Override
	public void acheter(Equipement item) throws Exception {
		dao.create(item);
	}

	@Override
	public void mettreAJoutEtat(Equipement item) throws Exception {
		this.update(item);
	}

	@Override
	public void reparer(Equipement item) throws Exception {
		item.setEtat(EtatEquipement.FONCTIONNE);
		this.update(item);
	}

	@Override
	public Equipement mettreADisposition(Integer id) throws Exception {
		Equipement item = dao.find(id);
		if (item.isReserve()) {
			throw new IndisponibiliteException(Indisponibilite.RESERVE, "Cet equipement est déjà reservé");
		} else if (item.getEtat() == EtatEquipement.CASSE) {
			throw new IndisponibiliteException(Indisponibilite.IRREPARABLE, "Cet equipement est cassé");
		}
		item.setReserve(true);
		this.update(item);
		return item;
	}

	@Override
	public void recuperer(Equipement item)throws Exception {
		item.setReserve(false);
		dao.update(item);
	}

	private void update(Equipement item) throws Exception {
		if (this.dao instanceof IGenericDao) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ETAT, item.getEtat());
			params.put(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_NOM, item.getNom());		
			params.put(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_REFERENCE, item.getReference());
			params.put(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_RESERVE, item.isReserve());
			params.put(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID, item.getId());
			((IGenericDao) this.dao).executeQuery(QueriesDictionary.EQUIPEMENT_UPDATE, params);
		} else {
			this.dao.update(item);
		}
	}

	@Override
	public void retirer(Equipement item) throws Exception {
		if (this.dao instanceof IGenericDao) {
			this.dao.delete(item.getId());
//			Map<String, Object> params = new HashMap<String, Object>();
//			params.put(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID, item.getId());
//			((IGenericDao) this.dao).executeQuery(QueriesDictionary.EQUIPEMENT_DELETE, params);
		} else {
			this.dao.delete(item.getId());
		}
	}

	public IDao<Equipement> getDao() {
		return dao;
	}

	public void setDao(IDao<Equipement> dao) {
		this.dao = dao;
	}

	@Override
	public List<Equipement> findWithQueryAutoBuild(String start, String contains, String end, Date startDate,
			Date endDate, float prixMin, float prixMax) {
		//Not done
		return null;
	}

	@Override
	public List<Equipement> findAll() {
		//Not done
		return null;
	}	

}
