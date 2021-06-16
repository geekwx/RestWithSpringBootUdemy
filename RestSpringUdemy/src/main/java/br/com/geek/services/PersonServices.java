package br.com.geek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geek.converter.DozerConverter;
import br.com.geek.data.model.Person;
import br.com.geek.data.vo.PersonVO;
import br.com.geek.exception.ResourceNotFoundException;
import br.com.geek.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parserObject(person, Person.class);
		var vo =  DozerConverter.parserObject(repository.save(entity), PersonVO.class);
		return vo ;
	}
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parserObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
	
	public PersonVO findById(Long id) {
		var entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parserObject(repository.save(entity), PersonVO.class);
	}
	public List<PersonVO> findAll() {
		return DozerConverter.parserListObject(repository.findAll(), PersonVO.class);
		}
		

	}


