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

	private Patient p1;
	private Patient p2;

	protected void setUp() throws Exception {
		super.setUp();
		this.context = new ClassPathXmlApplicationContext("emergency.xml");
		this.accueil = (IAccueil) context.getBean("accueil");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAccueil() {

		p1 = new Patient("Patient1", "p1");
		p1.setNumeroSECU("125454545");
		p1.setEtat(EtatPatient.ORDONNANCE);

		p2 = new Patient("Patient2", "p2");
		p2.setNumeroSECU("99797");
		p2.setEtat(EtatPatient.MORT);

		this.receptionner();
		
		
//		sortie();
	}

	private void receptionner() {
		try {

			Personne enf1 = new Personne("PATOULATCHI-SPRINGDATA", "Enfant1");
			Personne enf2 = new Personne("PATOULATCHI-SPRINGDATA", "Enfant2");

			Patient mere = new Patient("PATOULATCHI", "Maman");
			mere.getEnfants().add(enf1);
			mere.getEnfants().add(enf2);
			enf1.setMere(mere);
			enf2.setMere(mere);

			Personne pere_Chopin = new Personne("Chopin", "papa");
			Patient mere_Chopin = new Patient("Chopin", "maman");
			mere_Chopin.setNumeroSECU("125454545");

			Personne enf_Chopin = new Personne("Chopin", "Fréderic");
			enf_Chopin.setMere(mere_Chopin);
			enf_Chopin.setPere(pere_Chopin);

//			accueil.receptionner(p1);
//			accueil.receptionner(p2);

			accueil.receptionner(mere);
			
			mere.setNom("Nom modifié");
			mere.setPrenom("Prenom modifié");			
			mere.setEtat(EtatPatient.MORT);
			mere.setNumeroSECU("99999999");
			accueil.enregistrer(mere);
			
//			accueil.sortie(mere);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail("IAccueilTest.testReceptionner()" + ex.getMessage());
		}
	}

	private void sortie() {
		try {
			
			FeuilleSortie f1 = accueil.sortie(p1);
			FeuilleSortie f2 = accueil.sortie(p2);

			System.out.println("f1 = " + f1);
			System.out.println("f2 = " + f2);

		} catch (Exception e) {
			fail("IAccueilTest.testReceptionner()" + e.getMessage());
		}
	}

}
