package com.formation.emergency.business;

import java.util.UUID;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.FeuilleSortie;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.code.EtatPatient;
import com.formation.emergency.exception.RechercheException;

import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IAccueilTest extends TestCase {

	IAccueil accueil = null;
	ClassPathXmlApplicationContext context = null;

	public IAccueilTest() {
		context = new ClassPathXmlApplicationContext("emergency.xml");
		accueil = (IAccueil) context.getBean("accueil");
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
 
	protected void tearDown() throws Exception {
		super.tearDown();
		accueil = null;
		context = null;
	}

	public void testReceptionner() throws RechercheException {
		Patient person = new Patient();
		person.setNom("aaaaa");

		accueil.receptionner(person);

		assertTrue(true);

	}

	public void testsortie() throws RechercheException {
		Patient person = new Patient();
		person.setNom("bbb");
		person.setEtat(EtatPatient.CONSULTATION);
		
		
		accueil.receptionner(person);		

		FeuilleSortie sortie = accueil.sortie(person);
		if (sortie == null)
			fail("La sortie ne s'est pas faite");

		assertTrue(true);

	}

	public void testUpdate() throws RechercheException {

		Patient person = new Patient();
		person.setNom("ccc");
		accueil.receptionner(person);

		String newNumSecu = UUID.randomUUID().toString();
		person.setNumeroSecu(newNumSecu);

		accueil.mettreAJour(person);

		Patient newPerson = (Patient) accueil.cherche(person.getId());

		assertTrue(newPerson.getNumeroSecu().compareTo(newNumSecu) == 0);

	}
}
