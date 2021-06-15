package br.com.geek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geek.data.model.Person;
import br.com.geek.data.vo.PersonVO;
import br.com.geek.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	
	@GetMapping
	public List<PersonVO> findAll() {
		return services.findAll();	
	}
	
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id) ;	
	}
	
	
	
// Forma de request mais antiga - 	
//	@RequestMapping( method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, 
//			consumes = MediaType.APPLICATION_JSON_VALUE)
//	
	
	@PutMapping
		public PersonVO create(@RequestBody PersonVO person) {
			return services.create(person) ;	
	}
	@PutMapping
	public PersonVO update(@RequestBody Person person) {
		return services.update(person) ;	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
}
