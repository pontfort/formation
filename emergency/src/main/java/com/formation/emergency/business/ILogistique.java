package com.formation.emergency.business;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.Equipement;

public interface ILogistique {

	void acheter(Equipement item) throws Exception;
			
	void mettreAJoutEtat(Equipement item) throws Exception;
	
	void reparer(Equipement item) throws Exception;	
	
	void retirer(Equipement item) throws Exception;
	
	void retirer(Integer id) throws Exception;
	
	Equipement mettreADisposition(Integer id) throws Exception;
	
	void recuperer(Equipement item) throws Exception;
	
	List<Equipement> findAll();
	
	List<Equipement> findWithQueryAutoBuild(String start, String contains, String end, Date startDate, Date endDate, float prixMin, float prixMax);
	
		
}
