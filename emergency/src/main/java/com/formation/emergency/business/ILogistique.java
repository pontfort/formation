package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

public interface ILogistique {

	void acheter(Equipement equipement) throws IndisponibiliteException;
			
	void reparer(Equipement equipement) throws IndisponibiliteException;
	
	void retirer(Equipement equipement) throws IndisponibiliteException;
	
	Equipement mettreADisposition(String reference) throws IndisponibiliteException;
	
	void recuperer(Equipement equipement) throws IndisponibiliteException;
}
