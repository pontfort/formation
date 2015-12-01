package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

public interface ILogistique {

	public void acheter(Equipement equipement) throws IndisponibiliteException;

	public void reparer(Equipement equipement) throws IndisponibiliteException;

	public void retirer(Equipement equipement) throws IndisponibiliteException;

	public void recuperer(Equipement equipement) throws IndisponibiliteException;

	Equipement mettreADisposition(Object refEquipement) throws IndisponibiliteException;

}
