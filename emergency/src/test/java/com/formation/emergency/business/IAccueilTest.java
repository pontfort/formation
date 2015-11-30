package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	IAccueil accueil = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		//TODO instancier accueil
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		accueil = null;
	}

	public void testReceptionner() {
		try
		{
			Patient patient = new Patient();
			accueil.receptionner(patient);
			
		}
		catch (Exception ex)
		{
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}
	
	public void testSortie() {
		try {
			Patient patient = new Patient();
			FeuilleSortie feuille = accueil.sortie(patient);
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	

}
