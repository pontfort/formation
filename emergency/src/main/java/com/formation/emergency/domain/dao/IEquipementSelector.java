package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.SelectorPredicate;

public interface IEquipementSelector {

	List<Equipement> findByCriteria(Date dateMin, Date dateMax, String pays, String ref) throws Exception;
	
	List<Equipement> findByCriteriaAndStringBuilder(List<SelectorPredicate> selector) throws Exception;
}
