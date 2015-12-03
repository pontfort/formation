package com.formation.emergency.business;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.equipement.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

public interface ILogistique {

	public void acheter(Equipement equipement) throws IndisponibiliteException;

	public void reparer(Equipement equipement) throws IndisponibiliteException;

	public void retirer(Equipement equipement) throws IndisponibiliteException;

	public void recuperer(Equipement equipement) throws IndisponibiliteException;

	Equipement mettreADisposition(Object refEquipement) throws IndisponibiliteException;

	public List<Equipement> findByStemming(Date min, Date max, EtatEquipement fonctionnel, String string,
			String string2);


}
