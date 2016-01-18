package com.formation.emergency.business;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;
import com.formation.emergency.exception.IndisponibiliteException;

import junit.framework.TestCase;

public class ILogistiqueTest extends TestCase {

	ILogistique logistique = null;
	ClassPathXmlApplicationContext context = null;

	public ILogistiqueTest() {
		context = new ClassPathXmlApplicationContext("emergency.xml");
		logistique = (ILogistique) context.getBean("logistique");
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		logistique = null;
		context = null;
	}

	@Test
	public void testAcheter() throws IndisponibiliteException {
			Equipement voiture = (Equipement) context.getBean("voiture");
			logistique.acheter(voiture);

			assertTrue(true);

	}

	@Test
	public void testReparer() throws IndisponibiliteException {
			Equipement voiture = (Equipement) context.getBean("voiture");
			logistique.acheter(voiture);

			voiture.setEtat(EtatEquipement.CASSE);
			logistique.reparer(voiture);

			assertTrue(true);

	}

	@Test
	public void testPasReparer() throws IndisponibiliteException {
			Equipement voiture = (Equipement) context.getBean("voiture");
			voiture.setEtat(EtatEquipement.CASSE);
			logistique.acheter(voiture);

			logistique.reparer(voiture);


}

	@Test
	public void testRetirer() throws IndisponibiliteException {
			Equipement voiture =new Equipement();
			voiture.setType(TypeEquipement.BUREAU);
			voiture.setEtat(EtatEquipement.FONCTIONNEL);
			
			logistique.acheter(voiture);


			logistique.retirer(voiture);


	}

	@Test
	public void testRecuperer() throws IndisponibiliteException {
			Equipement voiture =new Equipement();
			voiture.setType(TypeEquipement.BUREAU);
			voiture.setEtat(EtatEquipement.FONCTIONNEL);
			
			logistique.acheter(voiture);


			logistique.recuperer(voiture);
	}

	@Test
	public void testMettreADisposition() throws IndisponibiliteException {
			Equipement voiture =new Equipement();
			voiture.setType(TypeEquipement.BUREAU);
			voiture.setEtat(EtatEquipement.FONCTIONNEL);
			
			logistique.acheter(voiture);


			logistique.mettreADisposition(voiture);

	}
	
	
	@Test
	public void testFindByCriteria() throws IndisponibiliteException{
		Calendar d= Calendar.getInstance();
		d.add(Calendar.DAY_OF_YEAR, -20);
		
		int initialCount= this.logistique.getbyCriteria("a", "m", "s",d.getTime() , 10, 20).size();
		
		Equipement e;		
		
		e= new Equipement();
		e.setReference("aaaaaammmmmmmmmmmmmmmssssss");
		e.setPrix(15);
		e.setDateAchat(Calendar.getInstance().getTime());
		this.logistique.acheter(e);
		

		e= new Equipement();
		e.setReference("aaaaaammmmmmmmmmmmmmmssssss");
		e.setPrix(25);
		e.setDateAchat(Calendar.getInstance().getTime());
		this.logistique.acheter(e);
		
		List<Equipement> l= this.logistique.getbyCriteria("a", "m", "s",d.getTime() , 10, 20);
		
		assertNotNull(l);
		assertEquals(1+initialCount,	l.size(), 0);
	}

}
