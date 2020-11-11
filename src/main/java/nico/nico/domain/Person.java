package nico.nico.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person
{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vorname;
    private String nachname;

    public List<Projektaufgabe> getProjektaufgaben() {
        return projektaufgaben;
    }

    public void setProjektaufgaben(List<Projektaufgabe> projektaufgaben) {
        this.projektaufgaben = projektaufgaben;
    }

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Projektaufgabe> projektaufgaben = new ArrayList<>();




    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Person()
    {

    }

}