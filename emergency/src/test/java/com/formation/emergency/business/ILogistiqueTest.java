package com.formation.emergency.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.impl.Logistique;
import com.formation.emergency.domain.dao.EquipementSelector;
import com.formation.emergency.domain.dao.IEquipementSelector;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.PredicateOperator;
import com.formation.emergency.domain.pojo.SelectorPredicate;
import com.formation.emergency.exception.IndisponibiliteException;

import junit.framework.TestCase;

	
public class ILogistiqueTest extends TestCase {
	
	ILogistique logistique = null;
	IEquipementSelector selector = null;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXmlApplicationContext("azam.xml");
		logistique = (ILogistique) app.getBean("logistique");
		selector = (IEquipementSelector) app.getBean("equipementSelector");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		logistique = null;
	}
	
	public void testAcheter() throws IndisponibiliteException, ParseException{
		Equipement equipement = new Equipement();
		equipement.setReference("test");
		equipement.setDisponible(true);
		equipement.setDateAchat(new SimpleDateFormat("yyyy/MM/dd").parse("2009/01/01"));
		logistique.acheter(equipement);
		selector.findByCriteria(new SimpleDateFormat("yyyy/MM/dd").parse("2007/01/01"), new SimpleDateFormat("yyyy/MM/dd").parse("2011/01/01"), true, "", "");
	}
	
	public void testReparer() throws Exception{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(true);
		logistique.acheter(equipement);
		equipement.setDisponible(false);
		logistique.reparer(equipement);
		List<SelectorPredicate> argList = new ArrayList<>();
		argList.add(0, new SelectorPredicate("disponible", "true", PredicateOperator.EQUALS));
		argList.add(1, new SelectorPredicate("reference", "AZERTY", PredicateOperator.LIKE));
		selector.findByCriteriaAndStringBuilder(argList);
	}
	
	public void testMettreADisposition() throws Exception{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(true);
		logistique.acheter(equipement);
		logistique.mettreADisposition(equipement.getReference());
	}
	
	public void testRecuperer() throws Exception{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(false);
		logistique.acheter(equipement);
		logistique.recuperer(equipement);
	}
	
	public void testRetirer() throws Exception{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(true);
		logistique.acheter(equipement);
		logistique.retirer(equipement);
	}

}
