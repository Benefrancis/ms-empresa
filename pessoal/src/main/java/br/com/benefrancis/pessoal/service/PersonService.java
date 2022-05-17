package br.com.benefrancis.pessoal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.benefrancis.pessoal.model.Address;
import br.com.benefrancis.pessoal.model.Person;
import br.com.benefrancis.pessoal.model.Phone;
import br.com.benefrancis.pessoal.repository.AddressRepository;
import br.com.benefrancis.pessoal.repository.PersonRepository;
import br.com.benefrancis.pessoal.repository.PhoneRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repo;
	@Autowired
	private PhoneRepository phoneRepo;

	@Autowired
	private AddressRepository addressRepo;

	public Person save(Person p) {

		Long id = p.getId();

		if (id != null && id > 0) {
			return repo.save(p);
		} else {
			Phone phone = phoneRepo.save(p.getAddress().getPhone());
			p.getAddress().setPhone(phone);
			Address address = addressRepo.save(p.getAddress());
			p.setAddress(address);
			return repo.save(p);
		}

	}

	public Page<Person> findAll(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Person findById(Long id) {
		return repo.findById(id).orElse(null);
	}

}
