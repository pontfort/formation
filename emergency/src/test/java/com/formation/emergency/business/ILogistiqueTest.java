package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.dao.jpa.EquipementDaoJPA;
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

	public void testLogistique() {

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

	public void testRechercherEquipement() {
		
		// l'AOP ne peut fonctionner car spring creer des proxy encapsulants les objets observés. Si l'objet n'est pas creer par springn, l'objet ne sera pas surveillé
		EquipementDaoJPA dao = new EquipementDaoJPA();
		
		//Impossible avec la transaction
//		dao.setEmf((EntityManagerFactory) context.getBean("myEmf"));
//		
//		Equipement amb1 = new Ambulance("Amb1", "Ambulance 1");
//		Equipement amb2 = new Ambulance("Amb2", "Ambulance 2");
//		Equipement def1 = new Equipement("Def1", "Defibrilateur 1");
//		Equipement def2 = new Equipement("Def2", "Defibrilateur 2");
//		Equipement def3 = new Equipement("Def1", "Defibrilateur 1");
//		Equipement def4 = new Equipement("Def2", "Defibrilateur 2");		
//		Equipement def5 = new Equipement("Def1", "Defibrilateur 1");
//		Equipement def6 = new Equipement("Def2", "Defibrilateur 2");
//		
//		amb1.setDateAchat(new Date(2014, 01, 01));
//		amb1.setReserve(true);
//		amb2.setDateAchat(new Date(2015, 06, 01));
//		amb2.setReserve(false);
//		def1.setDateAchat(new Date(2015, 06, 01));
//		def1.setReserve(true);		
//		
//				
//		dao.create(amb1);
//		dao.create(amb2);
//		dao.create(def1);
//		dao.create(def2);
//		dao.create(def3);
//		dao.create(def5);
//		dao.create(def4);
//		dao.create(def6);
//		
//		List<Equipement> result = dao.find(new Date(2015, 06, 01), new Date(2015, 12, 31), true, null, 0, null);
//		System.out.println("Nb de resultat : " + result.size());		
	}
}
