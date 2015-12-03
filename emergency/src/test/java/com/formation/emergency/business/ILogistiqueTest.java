package com.formation.emergency.business;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;
import com.formation.emergency.domain.pojo.equipement.Equipement;

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

	public void testAll() {
		acheter();
		// reparer();
		retirer();
	}

	private void retirer() {
		try {
			Equipement radio = getVoiture();
			radio.setEtat(EtatEquipement.CASSE);
			radio.setType(TypeEquipement.APPAREIL_RADIO);
			logistique.acheter(radio);

			logistique.retirer(radio);

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	private Equipement getVoiture() {
		Equipement equipement = new Equipement();
		equipement.setEtat(EtatEquipement.FONCTIONNEL);
		equipement.setType(TypeEquipement.VOITURE);
		return equipement;
	}

	private Equipement getRadio() {
		Equipement equipement = new Equipement();
		equipement.setEtat(EtatEquipement.FONCTIONNEL);
		equipement.setType(TypeEquipement.APPAREIL_RADIO);
		equipement.setDateAchet(new Date());
		equipement.setName("radio QM");
		equipement.setPays("France");
		return equipement;
	}

	private Equipement getRadio1() {
		Equipement equipement = new Equipement();
		equipement.setEtat(EtatEquipement.FONCTIONNEL);
		equipement.setType(TypeEquipement.APPAREIL_RADIO);
		equipement.setDateAchet(new Date());
		equipement.setName("radio FM");
		equipement.setPays("Dada");
		return equipement;
	}

	private Equipement getRadio2() {
		Equipement equipement = new Equipement();
		equipement.setEtat(EtatEquipement.FONCTIONNEL);
		equipement.setType(TypeEquipement.APPAREIL_RADIO);
		equipement.setDateAchet(new Date());
		equipement.setName("RTL");
		equipement.setPays("France");
		return equipement;
	}

	private Equipement getRadio3() {
		Equipement equipement = new Equipement();
		equipement.setEtat(EtatEquipement.FONCTIONNEL);
		equipement.setType(TypeEquipement.APPAREIL_RADIO);
		equipement.setDateAchet(new Date());
		equipement.setName("RMC");
		equipement.setRef("boby");
		equipement.setPays("France");
		return equipement;
	}

	private Equipement getRadio4() {
		Equipement equipement = new Equipement();
		equipement.setEtat(EtatEquipement.FONCTIONNEL);
		equipement.setType(TypeEquipement.APPAREIL_RADIO);
		equipement.setDateAchet(new Date());
		equipement.setName("BFM TV");
		equipement.setPays("France");
		return equipement;
	}

	public void acheter() {
		try {
			Equipement redio = getRadio();
			logistique.acheter(redio);
			redio = getRadio1();
			logistique.acheter(redio);
			redio = getRadio2();
			logistique.acheter(redio);
			redio = getRadio3();
			logistique.acheter(redio);
			redio = getRadio4();
			logistique.acheter(redio);

			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(new Date());
			gregorianCalendar.set(Calendar.YEAR, 2013);
			Date min = gregorianCalendar.getTime();
			gregorianCalendar.set(Calendar.YEAR, 2018);
			Date max = gregorianCalendar.getTime();
			List<Equipement> finds = logistique.findByStemming(min, max, EtatEquipement.FONCTIONNEL, "France", "boby");
			System.out.println("resultat : " + finds.size());
			for (Equipement equip : finds) {
			}

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	public void reparer() {
		try {
			Equipement voiture = getVoiture();
			logistique.acheter(voiture);

			voiture.setEtat(EtatEquipement.CASSE);
			logistique.reparer(voiture);

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.reparer()" + ex.getMessage());
		}
	}

}
