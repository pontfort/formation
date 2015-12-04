package com.formation.emergency.business;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.formation.emergency.domain.dao.EquipementSelector;
import com.formation.emergency.domain.pojo.Equipement;
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

		Equipement equipement = new Equipement();
		equipement.setReference("123456789");

		logistique.acheter(equipement);

		Date dateMin = new Date(2015, 11, 01);

		Date dateMax = new Date(2015, 11, 30);

		EquipementSelector equipementSelector = new EquipementSelector();

		equipementSelector.setEm(emf.createEntityManager());
		
		String pays = "";
		String ref = "";
		equipementSelector.findByCriteria(dateMin, dateMax, pays, ref);
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
