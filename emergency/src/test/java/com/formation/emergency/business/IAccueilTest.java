package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Patient;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	private IAccueil acceuil = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXml	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		acceuil = null;
	}

	public void testReceptionner() {
		Patient patient = new Patient();
		patient.setNumeroSecu("123456789");
		
		acceuil.receptionner(patient);
		
		fail("Not yet implemented");
	}

	public void testSortie() {
		fail("Not yet implemented");
	}

}
