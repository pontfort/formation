package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;

import junit.framework.TestCase;

public class ILogistiqueTest extends TestCase {

	ApplicationContext context = null;
	ILogistique logistique = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.context = new ClassPathXmlApplicationContext("emergency.xml");		
		this.logistique = (ILogistique) context.getBean("logistique");
	}

	protected void tearDown() throws Exception {
		super.tearDown();		
	}
	
	public void testLogistique() {
		
		Equipement amb1 = (Equipement) context.getBean("ambulance1");
		Equipement amb2 = (Equipement) context.getBean("ambulance2");
		Equipement def1 = (Equipement) context.getBean("defibrilateur1");
		Equipement def2 = (Equipement) context.getBean("defibrilateur2");
		
		try {
			this.logistique.acheter(amb1);
			this.logistique.acheter(amb2);
			this.logistique.acheter(def1);
			this.logistique.acheter(def2);
			
			this.logistique.mettreADisposition(amb1.getReference());
			this.logistique.mettreADisposition(def1.getReference());									
								
			try {
				this.logistique.mettreADisposition(amb1.getReference()); //fail
				assertFalse(true);
			} catch (Exception e) {				
				
			}
			
			this.logistique.recuperer(def1);
			
			def1.setEtat(EtatEquipement.CASSE);					
			
			try {
				this.logistique.mettreADisposition(def1.getReference()); //fail
				assertFalse(true);
			} catch (Exception e) {				
				
			}
			
			this.logistique.recuperer(amb1);
			
			this.logistique.reparer(def1);
			
			this.logistique.retirer(amb1);
			
			
		} catch (Exception e) {
			
			fail("IAccueilTest.testReceptionner()" + e.getMessage());
		}
		
		
	}	

}
