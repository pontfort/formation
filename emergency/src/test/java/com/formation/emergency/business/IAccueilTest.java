package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.EtatPatient;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	IAccueil accueil = null;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXmlApplicationContext("emergency.xml");
		accueil = (IAccueil) app.getBean("accueil");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		accueil = null;
	}

	public void testReceptionner() {
		try {
			Patient patient = new Patient();
			patient.setNumeroSecu("123456789");
			patient.setNom("Abadie");
			patient.setNom("Eric");
			patient.setEtatPatient(EtatPatient.CONSULTATION);
			
			accueil.receptionner(patient);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	public void testsortie() {
		try {
			Patient patient = new Patient();
			patient.setNumeroSecu("123456789");
			patient.setEtatPatient(EtatPatient.SORTIE_DEFINITIVE);
			
			FeuilleSortie feuilleSortie = accueil.sortie(patient);
			
		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}
}
