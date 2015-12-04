package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.Equipement;

public interface IDaoEquipement extends IDao<Equipement>  {
		
	List<Equipement> find(Date d1, Date d2, Boolean disponible, String paysOrigine, int degrePrecisionRecherchePays, String ref) throws Exception;
	
}
