package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.List;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.SelectorPredicate;

public interface IEquipementSelector {

	public List<Equipement> findByCriteria(Date dateMin, Date dateMax, boolean disponible, String pays, String ref);

	List<Equipement> findByCriteriaAndStringBuilder(List<SelectorPredicate> predicates) throws Exception;
}
