package com.formation.emergency.business;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.formation.emergency.domain.pojo.Equipement;

@WebService
public interface ILogistique {

	void acheter(Equipement item) throws Exception;

	void mettreAJoutEtat(Equipement item) throws Exception;

	void reparer(Equipement item) throws Exception;

	Equipement mettreADisposition(Integer id) throws Exception;

	void recuperer(Equipement item) throws Exception;

	List<Equipement> findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullDateAchatBetweenAndPriceBetweenOrderByPriceDesc(
			String refStart, String refContain, String refEnding, Date startDate, Date endingDate, int priceMin,
			int priceMax);

	List<Equipement> findAll();

	void retirer(Integer id) throws Exception;

}
