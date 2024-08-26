package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.models.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll(){
		
		logger.info("Finding all people");
		
		List<Person> people = new ArrayList<>();
		
		for(int i = 0; i < 8; i++) {
			Person person = getMockPerson(i);
			people.add(person);
		}
		
		return people;
		
	}
	
	public Person getMockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Breno " + i);
		person.setLastName("Abreu " + i);
		person.setAddress("Rua 123 456 " + i);
		person.setGender("Male " + i);
		return person;
	}
	
	public Person findById(String id) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Breno");
		person.setLastName("Abreu");
		person.setAddress("Rua 123 456");
		person.setGender("Male");
		
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting person!");
	}
}
