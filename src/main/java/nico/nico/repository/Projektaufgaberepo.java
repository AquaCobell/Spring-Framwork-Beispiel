package nico.nico.repository;

import nico.nico.domain.Projektaufgabe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Projektaufgaberepo extends JpaRepository<Projektaufgabe,Long> {
}
