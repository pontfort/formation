package com.formation.emergency.domain.dao;

import java.util.Date;
import java.util.List;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.equipement.Equipement;

public interface IRepository<T> {

	public void create(Object object);

	public void update(T object);

	public void delete(Object object);

	public T find(Object key);

	public List<T> findall();

	public List<Equipement> findByStemming(Date min, Date max, EtatEquipement etat, String pays, String chaine);

}
