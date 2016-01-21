package com.formation.emergency.business;

import javax.jws.WebService;

import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;
import com.formation.emergency.exception.RechercheException;

@WebService
public interface IAccueil {

	public boolean receptionner(Patient patient) throws RechercheException;

	public FeuilleSortie sortie(Patient patient) throws RechercheException;

	public Personne cherche(Integer id);

	public void mettreAJour(Personne person);	

}
