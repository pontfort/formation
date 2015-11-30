package com.formation.emergency.business;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	IAccueil accueil = null;
	ClassPathXmlApplicationContext context = null;

	protected void setUp() throws Exception {
		super.setUp();
		context = new ClassPathXmlApplicationContext("emergency.xml");
		accueil = (IAccueil) context.getBean("accueil");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		accueil = null;
		context = null;
	}

	public void testsortie() {
		try {
			Patient person = (Patient) context.getBean("personne");
			
			FeuilleSortie sortie = accueil.sortie(person);
			if (sortie == null)
				fail("La sortie ne s'est pas faite");
			
			assertTrue(true);
			
		} catch (Exception ex) {
			fail("IAccueilTest.testsortie()" + ex.getMessage());
		}
	}

	public void testReceptionner() {
		try {
			Patient person = (Patient) context.getBean("personne");
			accueil.receptionner(person);

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}


}
