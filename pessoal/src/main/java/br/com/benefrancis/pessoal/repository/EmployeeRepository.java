package br.com.benefrancis.pessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.benefrancis.pessoal.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
