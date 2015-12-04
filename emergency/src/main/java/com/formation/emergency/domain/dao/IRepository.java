package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.equipement.Equipement;

public interface IRepository<T> {

	public void create(Object object) throws Exception;

	public void update(T object) throws Exception;

	public void delete(Object object) throws Exception;

	public T find(Object key) throws Exception;

	public List<T> findall() throws Exception;

	public List<Equipement> findByStemming(Date min, Date max, EtatEquipement etat, String pays, String chaine)
			throws Exception;

}
