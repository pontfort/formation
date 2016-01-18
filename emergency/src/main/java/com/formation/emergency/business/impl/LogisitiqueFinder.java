package com.formation.emergency.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.formation.emergency.business.ILogisitiqueFinder;
import com.formation.emergency.domain.dao.repository.IDaoEquipement;
import com.formation.emergency.domain.dao.repository.jpa.OperatorPredicate;
import com.formation.emergency.domain.dao.repository.jpa.Predicate;
import com.formation.emergency.domain.pojo.Equipement;

public class LogisitiqueFinder implements ILogisitiqueFinder{

	private IDaoEquipement dao;
	
	@Override
	public List<Equipement> rechercher(Date d1, Date d2, Boolean reserve, String paysOrigine) throws Exception {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(new Predicate("dateAchat" ,d1, OperatorPredicate.GREATER_THAN));
		predicates.add(new Predicate("dateAchat" ,d2, OperatorPredicate.LESS_THAN));
		return dao.find(predicates);
	}

	public IDaoEquipement getDao() {
		return dao;
	}

	public void setDao(IDaoEquipement dao) {
		this.dao = dao;
	}

}
