package br.com.benefrancis.pessoal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.benefrancis.pessoal.model.Employee;
import br.com.benefrancis.pessoal.model.Person;
import br.com.benefrancis.pessoal.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private PersonService personService;

	public Employee save(Employee e) {

		Long id = e.getPerson().getId();

		if (id != null && id > 0) {
			return repo.save(e);
		} else {
			Person p = personService.save(e.getPerson());
			e.setPerson(p);
			return repo.save(e);
		}
	}

	public Page<Employee> findAll(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Employee findById(Long id) {
		return repo.findById(id).orElse(null);
	}

}
