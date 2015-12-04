package com.formation.emergency.domain.dao.Impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.emergency.domain.dao.IEquipmentSelector;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;

public class EquipmentSelectorImpl implements IEquipmentSelector {
	@PersistenceContext
	private EntityManager em;

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Equipement> findByCriteria(Date dateMin, Date dateMax, EtatEquipement etat, TypeEquipement type,
			String paysOrigine, String letters) throws Exception {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Equipement> q = cb.createQuery(Equipement.class);
		Root<Equipement> c = q.from(Equipement.class);

		if (dateMin != null)
			q.where(cb.greaterThan(c.<Date> get("dateAchat"), dateMin));
		if (dateMax != null)
			q.where(cb.lessThan(c.<Date> get("dateAchat"), dateMax));
		if (etat != null)
			q.where(cb.notEqual(c.<EtatEquipement> get("dateAchat"), etat));
		if (type != null)
			q.where(cb.notEqual(c.<TypeEquipement> get("dateAchat"), type));

		TypedQuery<Equipement> query = em.createQuery(q);

		return query.getResultList();
	}

}