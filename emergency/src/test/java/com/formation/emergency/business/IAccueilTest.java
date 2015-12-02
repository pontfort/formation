package com.formation.emergency.business;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.coordonnees.Patient;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IAccueilTest extends TestCase {

	IAccueil accueil = null;
	ClassPathXmlApplicationContext context = null;

	public IAccueilTest() {
		context = new ClassPathXmlApplicationContext("emergency.xml");
		accueil = (IAccueil) context.getBean("accueil");
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		accueil = null;
		context = null;
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

	public void testsortie() {
		try {
			Patient person = (Patient) context.getBean("personne");
			accueil.receptionner(person);

			FeuilleSortie sortie = accueil.sortie(person);
			if (sortie == null)
				fail("La sortie ne s'est pas faite");

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testsortie()" + ex.getMessage());
		}
	}

}
