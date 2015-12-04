package com.formation.emergency.domain.dao;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.formation.emergency.domain.pojo.Equipement;

@StaticMetamodel(Equipement.class)
public class Equip_ {
	public static volatile SingularAttribute<Equipement, Long> id;
	public static volatile SingularAttribute<Equipement, String> reference;
	public static volatile SingularAttribute<Equipement, Boolean> reserve;
	public static volatile SingularAttribute<Equipement, Date> dateAchat;
	public static volatile SingularAttribute<Equipement, String> PaysOrigine;
}