package com.formation.emergency.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.springrepository.IEquipementSpringJPA;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;


//@Service("logistique")
@Transactional
public class Logistique implements ILogistique {

	
	@Autowired private IEquipementSpringJPA equipementRepo; 
	
	@Override
	public void acheter(Equipement item) throws Exception {
		equipementRepo.saveAndFlush(item);		
	}

	@Override
	public void mettreAJoutEtat(Equipement item) throws Exception {
		equipementRepo.saveAndFlush(item);
	}
	
	@Override
	public void reparer(Equipement item) throws Exception {
		item.setEtat(EtatEquipement.FONCTIONNE);
//		this.equipementRepo.changerDispo(item.isReserve(),item.getId());
	}

	@Override
	public void retirer(Equipement item) throws Exception {
		equipementRepo.delete(item);		
	}

	@Override
	public Equipement mettreADisposition(Integer id) throws Exception {
		Equipement item = this.equipementRepo.findOne(id);
		if (item.isReserve()) {
			throw new IndisponibiliteException(Indisponibilite.RESERVE,"Cet equipement est déjà reservé");
		} else if (item.getEtat() == EtatEquipement.CASSE) {
			throw new IndisponibiliteException(Indisponibilite.IRREPARABLE,"Cet equipement est cassé");
		}
		item.setReserve(true);
		equipementRepo.saveAndFlush(item);
		return item;
	}

	@Override
	public void recuperer(Equipement item) throws Exception {
		item.setReserve(false);
		equipementRepo.saveAndFlush(item);
	}

	@Override
	public List<Equipement> findWithQueryAutoBuild(String start, String contains, String end, Date startDate,
			Date endDate, float prixMin, float prixMax) {		
		return equipementRepo.findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullAndDateAchatBetweenAndPrixBetweenOrderByPrixDesc(start, contains, end, startDate, endDate, prixMin, prixMax);
	}

	public IEquipementSpringJPA getEquipementRepo() {
		return equipementRepo;
	}

	public void setEquipementRepo(IEquipementSpringJPA equipementRepo) {
		this.equipementRepo = equipementRepo;
	}	
		
	
}
