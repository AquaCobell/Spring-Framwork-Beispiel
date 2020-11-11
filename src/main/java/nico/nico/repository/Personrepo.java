package nico.nico.repository;

import nico.nico.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Personrepo extends JpaRepository<Person,Long>
{

}
