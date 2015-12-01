package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.impl.Accueil;
import com.formation.emergency.domain.pojo.EtatPatient;
import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;
import com.formation.emergency.exception.RechercheException;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	IAccueil accueil = null;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXmlApplicationContext("azam.xml");
		accueil = (Accueil) app.getBean("accueil");
    	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		accueil = null;
	}

	public void testReceptionner() throws RechercheException {

			Patient patient = new Patient();
			patient.setNumeroSecu("AZAERTT");
			accueil.receptionner(patient);


	}

	public void testsortie() {
		try {
			Patient patient = new Patient();
			patient.setEtat(EtatPatient.DOIT_CONSULTER);
			patient.setNumeroSecu("AZAERTT");
			FeuilleSortie feuilleSortie = accueil.sortie(patient);
			
			
		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

}
