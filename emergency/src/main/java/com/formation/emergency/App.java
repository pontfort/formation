package com.formation.emergency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.Personne;
import com.formation.emergency.exception.RechercheException;

/**
 * ClassPathXmlApplicationContext context
 */
public class App {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("emergency.xml");
		Object bean = context.getBean("personne");
		IAccueil accueil = (IAccueil) context.getBean("accueil");
		if (bean instanceof Personne) {
			Personne person = ((Personne) bean);
			System.out.println(person.toString());
			System.out.println("--------------------------------\n");
			try {
				accueil.receptionner((Patient) person);
				System.out.println(accueil.toString());
				System.out.println("--------------------------------\n");
				accueil.sortie((Patient) person);
				System.out.println(accueil.toString());
			} catch (RechercheException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
