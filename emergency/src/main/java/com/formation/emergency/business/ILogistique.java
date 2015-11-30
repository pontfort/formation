package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteExpection;

public interface ILogistique {

	public void acheter(Equipement equipement) throws IndisponibiliteExpection;
	
	public void reparer(Equipement equipement) throws IndisponibiliteExpection;
	
	public void retirer(Equipement equipement) throws IndisponibiliteExpection;
	
	public Equipement mettreADisposition(String reference) throws IndisponibiliteExpection;
	
	public void recuperer(Equipement equipement) throws IndisponibiliteExpection;
	
}
