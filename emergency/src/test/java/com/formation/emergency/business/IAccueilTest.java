package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	ApplicationContext context = null;
	IAccueil accueil = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.context = new ClassPathXmlApplicationContext("emergency.xml");		
		this.accueil = (IAccueil) context.getBean("accueil");
	}

	protected void tearDown() throws Exception {
		super.tearDown();		
	}
	
	
	public void testAccueil() {
		receptionner();
		sortie();
	}
		
	private void receptionner() {
		try
		{
			Patient p1 = (Patient) context.getBean("patient1");
			Patient p2 = (Patient) context.getBean("patient2");
						
			accueil.receptionner(p1);
			accueil.receptionner(p2);
			
		}
		catch (Exception ex)
		{
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}
	
	private void sortie() {
		try {
			
			Patient p1 = (Patient) context.getBean("patient1");
			Patient p2 = (Patient) context.getBean("patient2");
			
			FeuilleSortie f1 = accueil.sortie(p1);
			FeuilleSortie f2 = accueil.sortie(p2);
			
			System.out.println("f1 = " + f1);
			System.out.println("f2 = " + f2);
			
		} catch (Exception e) {
			fail("IAccueilTest.testReceptionner()" + e.getMessage());
		}				
	}
	
	

}
