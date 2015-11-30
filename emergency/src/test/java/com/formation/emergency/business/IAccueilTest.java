package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.impl.Accueil;
import com.formation.emergency.domain.pojo.EtatPatient;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	IAccueil accueil = null;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXmlApplicationContext("azam.xml");
		Accueil acc = (Accueil) app.getBean("accueil");
    	
    	System.out.println(acc.toString());
		// TODO instancier accueil
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		accueil = null;
	}

	public void testReceptionner() {
		try {
			Patient patient = new Patient();
			accueil.receptionner(patient);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	public void testsortie() {
		try {
			Patient patient = new Patient();
			patient.setEtat(EtatPatient.DOIT_CONSULTER);
			FeuilleSortie feuilleSortie = accueil.sortie(patient);
			
			
		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

}
