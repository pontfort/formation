package com.formation.emergency.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.springrepo.ILogistiqueJPA;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;

//@Service("logistique")
@Transactional
public class Logistique implements ILogistique {

	@Autowired
	private ILogistiqueJPA logistique;

	@Override
	public void acheter(Equipement item) throws Exception {
		logistique.saveAndFlush(item);
	}

	@Override
	public void mettreAJoutEtat(Equipement item) throws Exception {
		logistique.saveAndFlush(item);
	}

	@Override
	public void reparer(Equipement item) throws Exception {
		item.setEtat(EtatEquipement.FONCTIONNE);
		logistique.saveAndFlush(item);
	}

	@Override
	public void retirer(Equipement item) throws Exception {
		logistique.delete(item.getId());
	}

	@Override
	public Equipement mettreADisposition(Integer id) throws Exception {
		Equipement item = logistique.findOne(id);
		if (item.isReserve()) {
			throw new IndisponibiliteException(Indisponibilite.RESERVE, "Cet equipement est déjà reservé");
		} else if (item.getEtat() == EtatEquipement.CASSE) {
			throw new IndisponibiliteException(Indisponibilite.IRREPARABLE, "Cet equipement est cassé");
		}
		item.setReserve(true);
		logistique.saveAndFlush(item);
		return item;
	}

	@Override
	public void recuperer(Equipement item) throws Exception {
		item.setReserve(false);
		logistique.saveAndFlush(item);
	}

	@Override
	public List<Equipement> findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullDateAchatBetweenAndPriceBetweenOrderByPriceDesc(
			String refStart, String refContain, String refEnding, Date startDate, Date endingDate, int priceMin,
			int priceMax) {

		return logistique
				.findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatIsNotNullAndDateAchatBetweenAndPriceBetweenOrderByPriceDesc(
						refStart, refContain, refEnding, startDate, endingDate, priceMin, priceMax);

	}

}
