package nico.nico.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
public class Projektaufgabe
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private boolean Abgabe;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "projekt_ID")
    @JsonIgnore
    private Person person;

    public Projektaufgabe()
    {

    }

    public Projektaufgabe(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAbgabe() {
        return Abgabe;
    }

    public void setAbgabe(boolean abgabe) {
        Abgabe = abgabe;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    /*public void getAbgabe()
    {
        return
    } */
}
