package com.formation.emergency.business;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.Equipement;

public interface ILogisitiqueFinder {
	
	List<Equipement> rechercher(Date d1, Date d2, Boolean reserve, String paysOrigine) throws Exception;

}
