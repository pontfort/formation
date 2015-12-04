package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.EtatPatient;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;
import com.formation.emergency.exception.RechercheException;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	ApplicationContext context = null;
	IAccueil accueil = null;

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

	public void testReceptionner() throws Exception {
		try {
			Patient patient = new Patient();
			patient.setNumeroSecu("123456789");
			patient.setNom("Abadie");
			patient.setPrenom("Eric");
			patient.setEtatPatient(EtatPatient.CONSULTATION);

			Patient enfant1 = new Patient();
			Patient enfant2 = new Patient();

			enfant1.setMere(patient);
			enfant2.setMere(patient);
			enfant1.setNumeroSecu("13245");
			enfant2.setNumeroSecu("54321");

			patient.getEnfants().add(enfant1);
			patient.getEnfants().add(enfant2);

			accueil.receptionner(patient);
		} catch (RechercheException ex) {			
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	// public void testsortie() {
	// try {
	// Patient patient = new Patient();
	// patient.setNumeroSecu("123456789");
	// patient.setEtatPatient(EtatPatient.SORTIE_DEFINITIVE);
	// patient.setNom("testUpdate");
	// patient.setMere(patient);
	// patient.setId(1);
	// FeuilleSortie feuilleSortie = accueil.sortie(patient);
	//
	// } catch (Exception ex) {
	// fail("IAccueilTest.testsortie()" + ex.getMessage());
	// }
	// }
}
