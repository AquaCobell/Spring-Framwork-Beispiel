package nico.nico.controller;

import nico.nico.domain.Person;
import nico.nico.domain.Projektaufgabe;
import nico.nico.service.Aufgabenservice;
import nico.nico.service.Personservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController
{
    Personservice perso;
    Aufgabenservice aufi;
    public AppController(Personservice perso, Aufgabenservice aufi)
    {
        this.perso = perso;
        this.aufi= aufi;
    }


    @RequestMapping("/users") //zeigt alle User
    public List<Person> zeigealleUser()
    {

        return perso.ListAll();
    }

    @RequestMapping("/aufgaben") //zeigt alle Aufgaben
    public List<Projektaufgabe> zeigealleProjektaufgaben()
    {

        return aufi.ListAll();
    }

    @GetMapping("/person/{id}") // gibt spezischen User
    public Person zeigespezifUser(@PathVariable(name = "id")Person test)
    {
        long id = test.getId();
        return perso.getPerson(id);
    }

    @GetMapping("/aufgabe/{id}") // gibt spezische aufgabe
    public Projektaufgabe zeigespezifAufgabe(@PathVariable(name = "id")Projektaufgabe test)
    {
        long id = test.getId();
        return aufi.getAufgabe(id);
    }

    @DeleteMapping("/person/{id}") //lösche einen User
    public ResponseEntity<String> löscheUser(@PathVariable(name = "id")Person test)
    {
        long id = test.getId();
        perso.deletePerson(id);

        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/aufgabe/{id}") //lösche eine aufgabe
    public ResponseEntity<String> löscheAufgabe(@PathVariable(name = "id")Projektaufgabe test)
    {
        long id = test.getId();
        aufi.deleteProjekt(id);

        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

    @PostMapping(path= "/person/", consumes = "application/json", produces = "application/json") //Erstelle neuen User
    public ResponseEntity<String> addUser(@RequestBody Person person)
    {
        perso.addPerson(person);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);

    }

    @PostMapping(path= "/Aufgabe/", consumes = "application/json", produces = "application/json") //Erstelle neuen User
    public ResponseEntity<String> addAufgabe(@RequestBody Projektaufgabe aufgabe)
    {
        aufi.addAufgabe(aufgabe);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);

    }

    @PutMapping(path= "/person/", consumes = "application/json", produces = "application/json") //Bearbeite User
    public ResponseEntity<String> editUser(@RequestBody Person person)
    {
        long id = person.getId();
        perso.editPerson(id, person);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);

    }

    @PutMapping(path= "/aufgabe/", consumes = "application/json", produces = "application/json") //Bearbeite Aufgabe
    public ResponseEntity<String> editAufgabe(@RequestBody Projektaufgabe aufgabe)
    {
        long id = aufgabe.getId();
        aufi.editAufgabe(id, aufgabe);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);

    }

    @GetMapping("/person/done/{id}") //Businesslogic -> Zeigt alle unerledigten Abgaben einer Projektaufgabe
    public List<Projektaufgabe> zeigeUnerledigteAbgaben(@PathVariable(name = "id")Person tmp)
    {
        long id = tmp.getId();
        return perso.getopenProjects(id);
    }
}
