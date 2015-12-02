package com.formation.emergency.business;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.equipement.Equipement;

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

	public void testAll() {
		acheter();
		reparer();
	}

	public void acheter() {
		try {
			Equipement voiture = (Equipement) context.getBean("voiture");
			logistique.acheter(voiture);

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	public void reparer() {
		try {
			Equipement voiture = (Equipement) context.getBean("voiture");
			logistique.acheter(voiture);

			voiture.setEtat(EtatEquipement.CASSE);
			logistique.reparer(voiture);

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	public void testPasReparer() {
		try {
			Equipement voiture = (Equipement) context.getBean("voiture");
			logistique.acheter(voiture);

			logistique.reparer(voiture);

			assertFalse(true);

		} catch (Exception ex) {
			assertTrue(true);
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

}
