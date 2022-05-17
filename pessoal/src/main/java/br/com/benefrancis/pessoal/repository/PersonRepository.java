package br.com.benefrancis.pessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.benefrancis.pessoal.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
