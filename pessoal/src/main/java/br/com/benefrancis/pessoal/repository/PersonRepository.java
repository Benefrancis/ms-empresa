package br.com.benefrancis.pessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.benefrancis.pessoal.model.Person;

//@RepositoryRestResource(path = "/api/v1/person", collectionResourceRel = "persons")
@Repository
public interface PersonRepository
		extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

}
