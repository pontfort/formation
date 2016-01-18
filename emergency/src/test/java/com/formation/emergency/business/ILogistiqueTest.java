package com.formation.emergency.business;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.dao.repository.jpa.EquipementDaoJPA;
import com.formation.emergency.domain.pojo.Ambulance;
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

	public void OldtestLogistique() {

		Equipement amb1 = new Ambulance("Amb1", "Ambulance 1");
		Equipement amb2 = new Ambulance("Amb2", "Ambulance 2");
		Equipement def1 = new Equipement("Def1", "Defibrilateur 1");
		Equipement def2 = new Equipement("Def2", "Defibrilateur 2");

		try {
			this.logistique.acheter(amb1);
			this.logistique.acheter(amb2);
			this.logistique.acheter(def1);
			this.logistique.acheter(def2);

			this.logistique.mettreADisposition(amb1.getId());
			this.logistique.mettreADisposition(def1.getId());

			try {
				this.logistique.mettreADisposition(amb1.getId()); // fail
				assertFalse(true);
			} catch (Exception e) {

			}

			this.logistique.recuperer(def1);

			def1.setNom("modifié");
			def1.setReference("/////");
			def1.setEtat(EtatEquipement.CASSE);
			this.logistique.mettreAJoutEtat(def1);

			try {
				this.logistique.mettreADisposition(def1.getId()); // fail
				assertFalse(true);
			} catch (Exception e) {

			}

			this.logistique.recuperer(amb1);

			this.logistique.reparer(def1);

			this.logistique.retirer(amb1);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			fail("IAccueilTest.testReceptionner()" + e.getMessage());
		}

	}

	public void OldtestRechercherEquipement() {

		// l'AOP ne peut fonctionner car spring creer des proxy encapsulants les
		// objets observés. Si l'objet n'est pas creer par springn, l'objet ne
		// sera pas surveillé
		EquipementDaoJPA dao = new EquipementDaoJPA();

		// Impossible avec la transaction
		// dao.setEmf((EntityManagerFactory) context.getBean("myEmf"));
		//
		// Equipement amb1 = new Ambulance("Amb1", "Ambulance 1");
		// Equipement amb2 = new Ambulance("Amb2", "Ambulance 2");
		// Equipement def1 = new Equipement("Def1", "Defibrilateur 1");
		// Equipement def2 = new Equipement("Def2", "Defibrilateur 2");
		// Equipement def3 = new Equipement("Def1", "Defibrilateur 1");
		// Equipement def4 = new Equipement("Def2", "Defibrilateur 2");
		// Equipement def5 = new Equipement("Def1", "Defibrilateur 1");
		// Equipement def6 = new Equipement("Def2", "Defibrilateur 2");
		//
		// amb1.setDateAchat(new Date(2014, 01, 01));
		// amb1.setReserve(true);
		// amb2.setDateAchat(new Date(2015, 06, 01));
		// amb2.setReserve(false);
		// def1.setDateAchat(new Date(2015, 06, 01));
		// def1.setReserve(true);
		//
		//
		// dao.create(amb1);
		// dao.create(amb2);
		// dao.create(def1);
		// dao.create(def2);
		// dao.create(def3);
		// dao.create(def5);
		// dao.create(def4);
		// dao.create(def6);
		//
		// List<Equipement> result = dao.find(new Date(2015, 06, 01), new
		// Date(2015, 12, 31), true, null, 0, null);
		// System.out.println("Nb de resultat : " + result.size());
	}
	
	public void OldtestLogistiqueSpringDataRepoPierre() {

		Equipement amb1 = new Ambulance("xumb sdfz", "amb1");
		Equipement amb2 = new Ambulance("xumbysdfz", "amb2");
		Equipement amb3 = new Equipement(" umbysdfz", "amb3");

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(new Date());
		amb1.setDateAchat(gregorianCalendar.getTime());
		amb1.setPrix(10.0f);
		amb1.setReserve(true);

		amb2.setDateAchat(gregorianCalendar.getTime());
		amb2.setPrix(20.0f);
		amb2.setReserve(true);

		amb3.setDateAchat(gregorianCalendar.getTime());
		amb3.setPrix(30.0f);
		amb3.setReserve(true);

		try {
			this.logistique.acheter(amb1);
			this.logistique.acheter(amb2);
			this.logistique.acheter(amb3);

			Date timeEnding = gregorianCalendar.getTime();

			gregorianCalendar.set(Calendar.DATE, -20);
			Date timeStart = gregorianCalendar.getTime();

			List<Equipement> result = this.logistique.findWithQueryAutoBuild("x", "y", "z", timeStart, timeEnding, 1.0f,
					33.0f);
			System.out.println("testLogistiqueSpringDataRepoPierre : Nb de resultat : " + result.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testLogistiqueSpringDataRepo() {

		GregorianCalendar gregorianCalendar = new GregorianCalendar();

		try {
			Equipement amb1 = new Ambulance("ref_1", "Ambulance 1");
			amb1.setDateAchat(gregorianCalendar.getTime());
			amb1.setPrix(100.0f);
			Equipement amb2 = new Ambulance("ref_1", "Ambulance 1 - bis");
			amb2.setDateAchat(gregorianCalendar.getTime());
			amb2.setPrix(100.0f);
			Equipement amb3 = new Ambulance("reg_1", "Ambulance 1 - ter");

			this.logistique.acheter(amb1);
			this.logistique.acheter(amb2);
			this.logistique.acheter(amb3);

			gregorianCalendar.add(GregorianCalendar.DATE, 1);
			Date d2 = gregorianCalendar.getTime();

			gregorianCalendar.set(Calendar.DATE, -20);
			Date d1 = gregorianCalendar.getTime();

			int count;
			count = this.logistique.findWithQueryAutoBuild("r", "ef", "1", d1, d2, 50.0f, 150.0f).size();
			System.out.println("testLogistiqueSpringDataRepo : Nombre d'equipement trouve = " + count);

			assertTrue(count == 2);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

}
