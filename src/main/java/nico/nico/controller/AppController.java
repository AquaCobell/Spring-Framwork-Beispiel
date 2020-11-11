package nico.nico.controller;

import nico.nico.domain.Person;
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
    public AppController(Personservice perso)
    {
        this.perso = perso;
    }


    @RequestMapping("/users")
    public List<Person> zeigealleUser()
    {
        System.out.println("hello there");
        return perso.ListAll();
    }

    @GetMapping("/person/{id}")
    public Person zeigespezifUser(@PathVariable(name = "id")Person test)
    {
        long id = test.getId();
        return perso.getPerson(id);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<String> löscheUser(@PathVariable(name = "id")Person test)
    {
        long id = test.getId();
        perso.deletePerson(id);

        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

    @PostMapping(path= "/person/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addUser(@RequestBody Person person)
    {
        perso.addPerson(person);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);

    }


}
