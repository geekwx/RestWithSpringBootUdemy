package br.com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geek.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	
}
