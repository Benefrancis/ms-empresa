package br.com.benefrancis.pessoal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.benefrancis.pessoal.model.Employee;
import br.com.benefrancis.pessoal.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping(value = { "/api/employee", "/api/employee/" })
	public ResponseEntity<Employee> save(@RequestBody(required = true) Employee e) {
		log.info("recebemos POST de Employee: " + e);
		return ResponseEntity.ok().body(service.save(e));
	}

	@CrossOrigin
	@GetMapping(value = { "/api/employee", "/api/employee/" })
	public ResponseEntity<Page<Employee>> lista(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "50") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		log.info("recebemos GET de Employee");
		return ResponseEntity.ok().body(service.findAll(page, linesPerPage, orderBy, direction));
	}
}