package nico.nico.controller;

import nico.nico.domain.Person;
import nico.nico.service.Personservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/Person/{id}")
    public Person zeigespezifUser(@PathVariable(name = "id")Person test)
    {
        long id = test.getId();
        return perso.getPerson(id);
    }
}
