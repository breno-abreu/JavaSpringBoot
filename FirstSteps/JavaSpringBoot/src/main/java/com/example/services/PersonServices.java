package com.example.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ResourceNotFoundException;
import com.example.vo.v1.PersonVO;
import com.example.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<PersonVO> findAll(){
		
		logger.info("Finding all people");
		return repository.findAll();
		
	}
	
	public PersonVO getMockPerson(int i) {
		PersonVO person = new PersonVO();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Breno " + i);
		person.setLastName("Abreu " + i);
		person.setAddress("Rua 123 456 " + i);
		person.setGender("Male " + i);
		return person;
	}
	
	public PersonVO findById(Long id) {
		
		logger.info("Finding one person!");
		
		// Se não achar nada, levanta uma exceção
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating person!");
		
		return repository.save(person);
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating person!");
		
		var entity = repository
				.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
			
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting person!");
		var entity = repository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
}
