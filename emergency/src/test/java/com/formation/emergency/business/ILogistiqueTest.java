package com.formation.emergency.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.formation.emergency.domain.dao.EquipementSelector;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.Operator;
import com.formation.emergency.domain.pojo.SelectorPredicate;

import junit.framework.TestCase;

public class ILogistiqueTest extends TestCase {

	ILogistique logistique = null;
	EntityManagerFactory emf = null;

	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext app = new ClassPathXmlApplicationContext("emergency.xml");
		emf = (EntityManagerFactory) app.getBean("myEmf");
		logistique = (ILogistique) app.getBean("logistique");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		logistique = null;
	}

	public void testAcheter() throws Exception {

//		Equipement equipement = new Equipement();
//		equipement.setReference("123456789");
//		equipement.setDateAchat(new Date(2015,11,10));
//
//		logistique.acheter(equipement);
//		
//		Equipement equipement2 = new Equipement();
//		equipement2.setReference("987654321");
//		equipement2.setDateAchat(new Date(2015, 11, 15));
//
//		logistique.acheter(equipement2);

		Date dateMin = new Date(115, 11, 01);

		Date dateMax = new Date(115, 11, 30);

		EquipementSelector equipementSelector = new EquipementSelector();

		equipementSelector.setEm(emf.createEntityManager());
		
		String pays = "";
		String ref = "";
		//equipementSelector.findByCriteria(dateMin, dateMax, pays, ref);
		
		List<SelectorPredicate> selectorPredicates = new ArrayList<SelectorPredicate>();
		String pattern = "yyyy-MM-dd";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
		selectorPredicates.add(new SelectorPredicate("dateAchat", format.format(dateMin), Operator.GREATERTHAN));
		selectorPredicates.add(new SelectorPredicate("dateAchat", format.format(dateMax), Operator.LESSTHAN));

		List<Equipement> equipements = equipementSelector.findByCriteriaAndStringBuilder(selectorPredicates);
		
		for (Equipement equip : equipements) {
			System.out.println(equip.getReference());
		}
	}

	public void reparer() {
		try {
			Equipement equipement = new Equipement();
			equipement.setReference("123456789");

			logistique.reparer(equipement);
		} catch (Exception ex) {
			fail("ILogistiqueTest.testReparer()" + ex.getMessage());
		}
	}

	public void retirer() {
		fail("Not yet implemented");
	}

	// public void testMettreADisposition() {
	// fail("Not yet implemented");
	// }
	//
	// public void testRecuperer() {
	// fail("Not yet implemented");
	// }

}
