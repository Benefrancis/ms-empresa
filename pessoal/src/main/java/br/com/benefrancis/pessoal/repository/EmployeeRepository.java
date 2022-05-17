package br.com.benefrancis.pessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.benefrancis.pessoal.model.Employee;
import br.com.benefrancis.pessoal.model.Person;

//@RepositoryRestResource(path = "/api/v1/employee", collectionResourceRel = "employees")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Person> {

}
