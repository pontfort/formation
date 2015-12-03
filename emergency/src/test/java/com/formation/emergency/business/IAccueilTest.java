package com.formation.emergency.business;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.code.EtatPatient;
import com.formation.emergency.domain.pojo.coordonnees.Adresse;
import com.formation.emergency.domain.pojo.coordonnees.Patient;
import com.formation.emergency.domain.pojo.coordonnees.Personne;

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

	public void testAll() {
		receptionner();
		sortie();
	}

	private Patient getMere() {
		Patient mere = new Patient();
		mere.setNom("Pontfort");
		mere.setPrenom("corinne");
		mere.setEtat(EtatPatient.CONSULTATION);
		mere.setDateNaissance(new Date());

		Adresse adresse = new Adresse();
		adresse.setAdresse("33 chemin des oliviers");
		adresse.setCodepostal("34400");
		adresse.setNumero("33");
		adresse.setPays("france");

		mere.setAdresse(adresse);

		Personne baptiste = new Personne();
		baptiste.setNom("Pontfort");
		baptiste.setPrenom("Baptiste");
		baptiste.setDateNaissance(new Date());
		baptiste.setMere(mere);

		Personne mathilde = new Personne();
		mathilde.setNom("Pontfort");
		mathilde.setPrenom("Mathilde");
		mathilde.setDateNaissance(new Date());
		mathilde.setMere(mere);

		mere.getChildren().add(mathilde);
		mere.getChildren().add(baptiste);

		return mere;
	}

	private Patient getPere() {
		Patient pere = new Patient();
		pere.setNom("Pontfort");
		pere.setPrenom("pierre");
		pere.setDateNaissance(new Date());

		Adresse adresse = new Adresse();
		adresse.setAdresse("33 chemin des oliviers");
		adresse.setCodepostal("34400");
		adresse.setNumero("33");
		adresse.setPays("france");

		return pere;
	}

	public void receptionner() {
		try {
			Patient mere = getMere();
			accueil.receptionner(mere);

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	public void sortie() {
		try {
			Patient pere = getPere();
			accueil.receptionner(pere);

			pere.setEtat(EtatPatient.MORT);
			pere.setNumeroSecu("New numero");
			pere.setNom("Nom de jeune fille");
			pere.setPrenom("New prenom");
			accueil.receptionner(pere);

			/*
			 * FeuilleSortie sortie = accueil.sortie(pere); if (sortie == null)
			 * fail("La sortie ne s'est pas faite");
			 */

			assertTrue(true);

		} catch (Exception ex) {
			fail("IAccueilTest.testsortie()" + ex.getMessage());
			System.out.println("IAccueilTest.sortie()" + ex.getMessage());
		}
	}

}
