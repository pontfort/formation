package com.formation.emergency.business;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

public interface ILogistique {

	public void acheter(Equipement equipement) throws IndisponibiliteException;

	public void reparer(Equipement equipement) throws IndisponibiliteException, Exception;

	public void retirer(Equipement equipement) throws IndisponibiliteException, Exception;

	public Equipement mettreADisposition(String refEquipement) throws IndisponibiliteException, Exception;

	public void recuperer(Equipement equipement) throws IndisponibiliteException, Exception;
	
	public List<Equipement> rechercheCustom(String commencePar, String contient, String finiPar, Date dateVingtJour, Date dateDuJour, int prixMin, int prixMax);

}
