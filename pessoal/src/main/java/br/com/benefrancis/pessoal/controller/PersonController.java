package br.com.benefrancis.pessoal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.benefrancis.pessoal.model.Person;
import br.com.benefrancis.pessoal.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	private static final Logger log = LoggerFactory.getLogger(PersonController.class);

	@RequestMapping(value = { "/api/v0/person", "/api/v0/person/" }, method = RequestMethod.POST)
	public ResponseEntity<Person> save(@RequestBody(required = true) Person p) {
		log.info("recebemos POST de Person: " + p);
		return ResponseEntity.ok().body(service.save(p));
	}
	
	@CrossOrigin
	@GetMapping(value = { "/api/v0/person", "/api/v0/person/" })
	public ResponseEntity<Page<Person>> lista(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "50") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		log.info("recebemos GET de Person");
		return ResponseEntity.ok().body(service.findAll(page, linesPerPage, orderBy, direction));
	}
	
	@CrossOrigin
	@GetMapping(value = { "/api/v0/person/{id}", "/api/v0/person/{id}" })
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		log.info("recebemos GET de Person");
		return ResponseEntity.ok().body(service.findById(id));
	}

}
