package com.formation.emergency.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;
import com.formation.emergency.domain.pojo.code.EtatPatient;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

import junit.framework.TestCase;

public class IAccueilTest extends TestCase {

	ApplicationContext context = null;
	IAccueil accueil = null;

	private Patient mere;
	private Patient pere;

	protected void setUp() throws Exception {
		super.setUp();
		this.context = new ClassPathXmlApplicationContext("emergency.xml");
		this.accueil = (IAccueil) context.getBean("accueil");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAccueil() {

		mere = new Patient("Patient1", "mere1");
		mere.setNumeroSECU("125454545");
		mere.setEtat(EtatPatient.ORDONNANCE);

		pere = new Patient("Patient2", "pere2");
		pere.setNumeroSECU("99797");
		pere.setEtat(EtatPatient.CONSULTATION);

		receptionner();
		sortie();
	}

	private void receptionner() {
		try {

			Personne enf1 = new Personne("PATOULATCHI", "Enfant1");
			Personne enf2 = new Personne("PATOULATCHI", "Enfant2");

			mere.getEnfants().add(enf1);
			mere.getEnfants().add(enf2);
			enf1.setMere(mere);
			enf2.setMere(mere);

			accueil.receptionner(mere);
			accueil.receptionner(pere);

			mere.setEtat(EtatPatient.MORT);
			accueil.enregistrer(mere);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	private void sortie() {
		try {

			FeuilleSortie f1 = accueil.sortie(mere);
			FeuilleSortie f2 = accueil.sortie(pere);

			System.out.println("f1 = " + f1);
			System.out.println("f2 = " + f2);

		} catch (Exception e) {
			fail("IAccueilTest.testReceptionner()" + e.getMessage());
		}
	}

}
