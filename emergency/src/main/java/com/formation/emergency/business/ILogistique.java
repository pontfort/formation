package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

public interface ILogistique {

	void acheter(Equipement item) throws IndisponibiliteException;
			
	void reparer(Equipement item) throws IndisponibiliteException;
	
	void retirer(Equipement item) throws IndisponibiliteException;
	
	Equipement mettreADisposition(String reference) throws IndisponibiliteException;
	
	void recuperer(Equipement item) throws IndisponibiliteException;
}
