package com.formation.emergency.domain.dao;

import java.util.*;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;

public interface IEquipmentSelector {
	public List<Equipement> findByCriteria(Date dateMin,Date dateMax, EtatEquipement etat,TypeEquipement type,
									String paysOrigine, String letters);
}
