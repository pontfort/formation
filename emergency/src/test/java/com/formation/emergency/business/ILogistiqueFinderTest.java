package com.formation.emergency.business;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.dao.jpa.EquipementDaoJPA;
import com.formation.emergency.domain.pojo.Ambulance;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;

import junit.framework.TestCase;

public class ILogistiqueFinderTest extends TestCase {

	ApplicationContext context = null;
	ILogistique logistique = null;
	ILogisitiqueFinder logistiqueFinder = null;

	protected void setUp() throws Exception {
		super.setUp();
		this.context = new ClassPathXmlApplicationContext("emergency.xml");
		this.logistique = (ILogistique) context.getBean("logistique");
		this.logistiqueFinder = (ILogisitiqueFinder) context.getBean("logistiqueFinder");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testRechercherEquipement() {
		
		// l'AOP ne peut fonctionner car spring creer des proxy encapsulants les objets observés. Si l'objet n'est pas creer par springn, l'objet ne sera pas surveillé		
					
		Equipement amb1 = new Ambulance("Amb1", "Ambulance 1");
		Equipement amb2 = new Ambulance("Amb2", "Ambulance 2");
		Equipement def1 = new Equipement("Def1", "Defibrilateur 1");
		Equipement def2 = new Equipement("Def2", "Defibrilateur 2");
		Equipement def3 = new Equipement("Def1", "Defibrilateur 1");
		Equipement def4 = new Equipement("Def2", "Defibrilateur 2");		
		Equipement def5 = new Equipement("Def1", "Defibrilateur 1");
		Equipement def6 = new Equipement("Def2", "Defibrilateur 2");
		
		amb1.setDateAchat(new Date(2014, 01, 01));
		amb1.setReserve(true);
		amb2.setDateAchat(new Date(2015, 06, 01));
		amb2.setReserve(false);
		def1.setDateAchat(new Date(2015, 06, 01));
		def1.setReserve(true);		
		
				
		try {
			this.logistique.acheter(amb1);
			this.logistique.acheter(amb2);
			this.logistique.acheter(def1);
			this.logistique.acheter(def2);
			this.logistique.acheter(def3);
			this.logistique.acheter(def5);
			this.logistique.acheter(def4);
			this.logistique.acheter(def6);
			
			List<Equipement> result = this.logistiqueFinder.rechercher(new Date(2013, 06, 01), new Date(2015, 12, 31), true, null);
			System.out.println("Nb de resultat : " + result.size());
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
}
