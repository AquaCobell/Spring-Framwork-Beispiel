package nico.nico;

import nico.nico.domain.Person;
import nico.nico.domain.Projektaufgabe;
import nico.nico.repository.Personrepo;
import nico.nico.service.Personservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NicoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(NicoApplication.class, args);

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(NicoApplication.class, args);
		Personrepo repo = configurableApplicationContext.getBean(Personrepo.class);

		Personservice ser = new Personservice() ;
		Person person = new Person();
		person.setNachname("Rieser");
		person.setVorname("Nico");
		person.setId(1);

		Projektaufgabe proj1 = new Projektaufgabe();
		proj1.setAbgabe(true);
		proj1.setName("Maven");

		Projektaufgabe proj2 = new Projektaufgabe();
		proj1.setAbgabe(false);
		proj1.setName("Intellij");

		List<Projektaufgabe> liste = new ArrayList<>();

		liste.add(proj1);
		liste.add(proj2);

		person.setProjektaufgaben(liste);
		repo.save(person);
		repo.findAll();


		//ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(NicoApplication.class, args);
		//		UserRepo userrepo = configurableApplicationContext.getBean(UserRepo.class);

	}

}
