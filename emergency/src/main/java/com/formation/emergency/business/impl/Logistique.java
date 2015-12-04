package com.formation.emergency.business.impl;

import org.springframework.transaction.annotation.Transactional;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.dao.IDao;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.formation.emergency.exception.code.Indisponibilite;


//@Service("logistique")
@Transactional
public class Logistique implements ILogistique {

//  Utiliser le @Autowired quand on est à l'interieur d'une couche (indoor) / utliser le xml quand on est outdoor	
//	@Autowired
//	@Qualifier("equipementDao")	
	private IDao<Equipement> dao;
	
	@Override
	public void acheter(Equipement item) throws Exception {
		dao.create(item);		
	}

	@Override
	public void mettreAJoutEtat(Equipement item) throws Exception {
		dao.update(item);		
	}
	
	@Override
	public void reparer(Equipement item) throws Exception {
		item.setEtat(EtatEquipement.FONCTIONNE);
		dao.update(item);
	}

	@Override
	public void retirer(Equipement item) throws Exception {
		dao.delete(item.getId());		
	}

	@Override
	public Equipement mettreADisposition(Integer id) throws Exception {
		Equipement item = dao.find(id);
		if (item.isReserve()) {
			throw new IndisponibiliteException(Indisponibilite.RESERVE,"Cet equipement est déjà reservé");
		} else if (item.getEtat() == EtatEquipement.CASSE) {
			throw new IndisponibiliteException(Indisponibilite.IRREPARABLE,"Cet equipement est cassé");
		}
		item.setReserve(true);
		dao.update(item);
		return item;
	}

	@Override
	public void recuperer(Equipement item) throws Exception {
		item.setReserve(false);
		dao.update(item);
	}

	public IDao<Equipement> getDao() {
		return dao;
	}

	public void setDao(IDao<Equipement> dao) {
		this.dao = dao;
	}
	
}
