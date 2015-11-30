package com.formation.emergency.business;

import com.formation.emergency.domain.pojo.Adresse;
import com.formation.emergency.domain.pojo.Patient;

import junit.framework.TestCase;

public class IAmbulancierTest extends TestCase {

	IAmbulancier ambulancier = null;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		IAmbulancier ambulancier = null;
	}
	
	public void testTransporter() {
		try
		{
			Patient patient = new Patient();
			Adresse depart = new Adresse();
			Adresse arrivee = new Adresse();
			
			ambulancier.transporter(patient, depart, arrivee);
		}
		catch (Exception ex)
		{
			fail("IAccueilTest.testTransporter()" + ex.getMessage());
		}
	}
}
