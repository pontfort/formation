package com.formation.emergency.business;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

@WebService
public interface ILogistique {

	public void acheter(Equipement equipement) throws IndisponibiliteException;

	public void reparer(Equipement equipement) throws IndisponibiliteException;

	public void retirer(Equipement equipement) throws IndisponibiliteException;

	public void recuperer(Equipement equipement) throws IndisponibiliteException;

	Equipement mettreADisposition(Object refEquipement) throws IndisponibiliteException;
	
	List<Equipement> getbyCriteria(String sarting, String containing, String ending, Date dateachat,int prixmin, int prixmax);

	public Equipement getById(Integer eqId);

	public List<Equipement> FindAll();
}
