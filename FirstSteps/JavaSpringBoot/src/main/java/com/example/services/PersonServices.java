package com.example.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ResourceNotFoundException;
import com.example.models.Person;
import com.example.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll(){
		
		logger.info("Finding all people");
		return repository.findAll();
		
	}
	
	public Person getMockPerson(int i) {
		Person person = new Person();
		/*person.setId(counter.incrementAndGet());
		person.setFirstName("Breno " + i);
		person.setLastName("Abreu " + i);
		person.setAddress("Rua 123 456 " + i);
		person.setGender("Male " + i);*/
		return person;
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding one person!");
		
		// Se não achar nada, levanta uma exceção
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
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
