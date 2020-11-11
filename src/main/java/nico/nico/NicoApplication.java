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
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class NicoApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(NicoApplication.class, args);
		Personrepo userrepo = configurableApplicationContext.getBean(Personrepo.class);

		Person user = new Person("C999");
		Projektaufgabe maven = new Projektaufgabe("Maven",user);
		Projektaufgabe intellij = new Projektaufgabe("INtellij",user);
		List<Projektaufgabe> projekte = Arrays.asList(intellij,maven);
		user.setProjektaufgaben(projekte);
		userrepo.save(user);
		//User user2 = new User("reinhard");
		//userrepo.save(user2);

	}

}
