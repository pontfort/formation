package com.formation.emergency.business;

import java.util.List;

import javax.jws.WebService;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

@WebService
public interface IAccueil {

	boolean receptionner(Patient patient) throws Exception;

	void enregistrer(Patient patient) throws Exception;

	FeuilleSortie sortie(Patient patient) throws Exception;

	List<Patient> findAll() throws Exception;

}
