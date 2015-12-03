package com.formation.emergency.business;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;
import com.formation.emergency.exception.IndisponibiliteException;

import junit.framework.TestCase;

public class ILogistiqueTest extends TestCase {

	ILogistique logistique = null;
	ClassPathXmlApplicationContext context = null;

	public ILogistiqueTest() {
		context = new ClassPathXmlApplicationContext("emergency.xml");
		logistique = (ILogistique) context.getBean("logistique");
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		logistique = null;
		context = null;
	}

	@Test
	public void testAcheter() throws IndisponibiliteException {
			Equipement voiture = (Equipement) context.getBean("voiture");
			logistique.acheter(voiture);

			assertTrue(true);

	}

	@Test
	public void testReparer() throws IndisponibiliteException {
			Equipement voiture = (Equipement) context.getBean("voiture");
			logistique.acheter(voiture);

			voiture.setEtat(EtatEquipement.CASSE);
			logistique.reparer(voiture);

			assertTrue(true);

	}

	@Test
	public void testPasReparer() throws IndisponibiliteException {
			Equipement voiture = (Equipement) context.getBean("voiture");
			voiture.setEtat(EtatEquipement.CASSE);
			logistique.acheter(voiture);

			logistique.reparer(voiture);


}

	@Test
	public void testRetirer() throws IndisponibiliteException {
			Equipement voiture =new Equipement();
			voiture.setType(TypeEquipement.BUREAU);
			voiture.setEtat(EtatEquipement.FONCTIONNEL);
			
			logistique.acheter(voiture);


			logistique.retirer(voiture);


	}

	@Test
	public void testRecuperer() throws IndisponibiliteException {
			Equipement voiture =new Equipement();
			voiture.setType(TypeEquipement.BUREAU);
			voiture.setEtat(EtatEquipement.FONCTIONNEL);
			
			logistique.acheter(voiture);


			logistique.recuperer(voiture);
	}

	@Test
	public void testMettreADisposition() throws IndisponibiliteException {
			Equipement voiture =new Equipement();
			voiture.setType(TypeEquipement.BUREAU);
			voiture.setEtat(EtatEquipement.FONCTIONNEL);
			
			logistique.acheter(voiture);


			logistique.mettreADisposition(voiture);

	}

}
