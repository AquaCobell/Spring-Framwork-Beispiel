package nico.nico.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "Person")
public class Person
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String vorname;
    private String nachname;

    public Person(String vorname) {
        this.vorname = vorname;
    }

    public List<Projektaufgabe> getProjektaufgaben() {
        return projektaufgaben;
    }

    public void setProjektaufgaben(List<Projektaufgabe> projektaufgaben) {
        this.projektaufgaben = projektaufgaben;
    }
    @JsonManagedReference
    @OneToMany
            (
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Projektaufgabe> projektaufgaben = new ArrayList<>();




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
