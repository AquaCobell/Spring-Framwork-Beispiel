package nico.nico.service;

import nico.nico.domain.Person;
import nico.nico.domain.Projektaufgabe;
import nico.nico.repository.Personrepo;
import nico.nico.repository.Projektaufgaberepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Aufgabenservice {

    @Autowired
    Projektaufgaberepo repo;


    public void addAufgabe(Projektaufgabe p)
    {
        repo.save(p);
    }
    public List<Projektaufgabe> ListAll()
    {
        return repo.findAll();
    }

    public Projektaufgabe getAufgabe(long id)
    {
        Optional<Projektaufgabe> temp  = repo.findById(id);
        if (temp.isPresent())
        {
            Projektaufgabe projekt = temp.get();
            return projekt;
        }

        return null;
    }
    public void deleteProjekt(long id)
    {
        repo.deleteById(id);
    }
    public Aufgabenservice()
    {

    }
    public void editAufgabe(long id, Projektaufgabe aufgabe)
    {
        Optional<Projektaufgabe> temp = repo.findById(id);
        if(temp.isPresent())
        {
            Projektaufgabe temp2 = temp.get();

            temp2.setAbgabe(aufgabe.isAbgabe());
            temp2.setName(aufgabe.getName());
            //temp2.setPerson(aufgabe.getPerson());


            repo.save(temp2);
        }

    }

}
