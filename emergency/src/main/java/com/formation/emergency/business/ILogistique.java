package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Equipement;

public interface ILogistique {

	void acheter(Equipement item) throws Exception;
			
	void mettreAJoutEtat(Equipement item) throws Exception;
	
	void reparer(Equipement item) throws Exception;	
	
	void retirer(Equipement item) throws Exception;
	
	Equipement mettreADisposition(Integer id) throws Exception;
	
	void recuperer(Equipement item) throws Exception;
		
}
