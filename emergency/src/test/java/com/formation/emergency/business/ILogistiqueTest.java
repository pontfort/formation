package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.formation.emergency.domain.pojo.Equipement;
import junit.framework.TestCase;

public class ILogistiqueTest extends TestCase {

	ILogistique logistique = null;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXmlApplicationContext("emergency.xml");
		logistique = (ILogistique) app.getBean("logistique");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		logistique = null;
	}

	public void testAcheter() {
		try {
			Equipement equipement = new Equipement();
			equipement.setReference("123456789");

			logistique.acheter(equipement);
		} catch (Exception ex) {
			fail("ILogistiqueTest.testAcheter()" + ex.getMessage());
		}
	}

	public void reparer() {
		try {
			Equipement equipement = new Equipement();
			equipement.setReference("123456789");

			logistique.reparer(equipement);
		} catch (Exception ex) {
			fail("ILogistiqueTest.testReparer()" + ex.getMessage());
		}
	}

	public void retirer() {
		fail("Not yet implemented");
	}

//	public void testMettreADisposition() {
//		fail("Not yet implemented");
//	}
//
//	public void testRecuperer() {
//		fail("Not yet implemented");
//	}

}
