package com.formation.emergency.business;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.Ambulance;
import com.formation.emergency.domain.pojo.Equipement;

import junit.framework.TestCase;

public class ILogistiqueFinderTest extends TestCase {

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

	public void testRechercherEquipement() {

		// l'AOP ne peut fonctionner car spring creer des proxy encapsulants les
		// objets observés. Si l'objet n'est pas creer par springn, l'objet ne
		// sera pas surveillé

		Equipement amb1 = new Ambulance("xumb sdfz", "amb1");
		Equipement amb2 = new Ambulance("xumbysdfz", "amb2");
		Equipement amb3 = new Equipement(" umbysdfz", "amb3");

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(new Date());
		amb1.setDateAchat(gregorianCalendar.getTime());
		amb1.setPrice(10);
		amb1.setReserve(true);
		amb2.setDateAchat(gregorianCalendar.getTime());
		amb2.setPrice(20);
		amb2.setReserve(true);
		amb3.setDateAchat(gregorianCalendar.getTime());
		amb3.setPrice(30);
		amb3.setReserve(true);

		try {
			this.logistique.acheter(amb1);
			this.logistique.acheter(amb2);
			this.logistique.acheter(amb3);

			gregorianCalendar.set(Calendar.DATE, gregorianCalendar.get(Calendar.DATE) + 1);
			Date timeEnding = gregorianCalendar.getTime();

			gregorianCalendar.set(Calendar.DATE, -20);
			Date timeStart = gregorianCalendar.getTime();

			List<Equipement> result = this.logistique
					.findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullDateAchatBetweenAndPriceBetweenOrderByPriceDesc(
							"x", "y", "z", timeStart, timeEnding, 1, 33);
			System.out.println("Nb de resultat : " + result.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
