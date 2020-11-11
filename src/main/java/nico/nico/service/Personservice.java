package nico.nico.service;

import nico.nico.domain.Person;
import nico.nico.repository.Personrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Personservice
{
    @Autowired
    Personrepo repo;

    public void addPerson(Person p)
    {
        repo.save(p);
    }
    public List<Person> ListAll()
    {
        return repo.findAll();
    }

    public Person getPerson(long id)
    {
        Optional<Person> temp  = repo.findById(id);
        if (temp.isPresent())
        {
            Person person = temp.get();
            return person;
        }
        return null;
    }
    public void deletePerson(long id)
    {
        repo.deleteById(id);
    }
    public Personservice()
    {

    }
    public void editPerson(long id, Person person)
    {
        Optional<Person> temp = repo.findById(id);
        if(temp.isPresent())
        {
            Person temp2 = temp.get();
            temp2.setNachname(person.getNachname());
            temp2.setVorname(person.getVorname());

            //temp2.getProjektaufgaben().clear();
            //temp2.setProjektaufgaben(person.getProjektaufgaben());

            repo.save(temp2);
        }

    }
}
