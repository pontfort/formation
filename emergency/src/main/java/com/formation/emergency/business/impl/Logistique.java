package com.formation.emergency.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.repository.IRepository;
import com.formation.emergency.domain.dao.springrepo.IEquipementJPA;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

@Transactional
public class Logistique implements ILogistique {

	private IRepository<Equipement> equipementDao;
	@Autowired
	private IEquipementJPA equipementRepo;
	
	@Override
	public void acheter(Equipement equipement) throws IndisponibiliteException {
		// TODO Auto-generated method stub
		equipementDao.create(equipement);
	}

	@Override
	public void reparer(Equipement equipement) throws Exception {
		// TODO Auto-generated method stub
		equipementDao.update(equipement);
	}

	@Override
	public void retirer(Equipement equipement) throws Exception {
		// TODO Auto-generated method stub
		equipementDao.delete(equipement.getReference());
	}

	@Override
	public Equipement mettreADisposition(String refEquipement) throws Exception {
		// TODO Auto-generated method stub
		Equipement equipement = equipementDao.read(refEquipement);
		equipement.setDisponible(false);
		equipementDao.update(equipement);
		return equipement;
	}

	@Override
	public void recuperer(Equipement equipement) throws Exception {
		// TODO Auto-generated method stub
		equipement.setDisponible(true);
		equipementDao.update(equipement);
	}

	public IRepository<Equipement> getEquipementDao() {
		return equipementDao;
	}

	public void setEquipementDao(IRepository<Equipement> equipementDao) {
		this.equipementDao = equipementDao;
	}

	@Override
	public List<Equipement> rechercheCustom(String commencePar, String contient, String finiPar, Date dateVingtJour, Date dateDuJour, int prixMin, int prixMax) {
		return equipementRepo.findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullAndDateAchatBetweenAndPrixBetweenOrderByPrixDesc(commencePar, contient, finiPar, dateVingtJour, dateDuJour, prixMin, prixMax);
	}

}
