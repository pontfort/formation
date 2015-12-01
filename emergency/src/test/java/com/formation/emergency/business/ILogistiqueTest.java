package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.impl.Logistique;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

import junit.framework.TestCase;

	
public class ILogistiqueTest extends TestCase {
	
	ILogistique logistique = null;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXmlApplicationContext("azam.xml");
		logistique = (Logistique) app.getBean("logistique");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		logistique = null;
	}
	
	public void testAcheter() throws IndisponibiliteException{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(true);
		logistique.acheter(equipement);
	}
	
	public void testReparer() throws IndisponibiliteException{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(true);
		logistique.acheter(equipement);
		equipement.setDisponible(false);
		logistique.reparer(equipement);
	}
	
	public void testMettreADisposition() throws IndisponibiliteException{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(true);
		logistique.acheter(equipement);
		logistique.mettreADisposition(equipement.getReference());
	}
	
	public void testRecuperer() throws IndisponibiliteException{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(false);
		logistique.acheter(equipement);
		logistique.recuperer(equipement);
	}
	
	public void testRetirer() throws IndisponibiliteException{
		Equipement equipement = new Equipement();
		equipement.setReference("AZERTY");
		equipement.setDisponible(true);
		logistique.acheter(equipement);
		logistique.retirer(equipement);
	}

}
