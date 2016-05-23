package chapter01.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import chapter01.person.dao.PersonRepository;
import chapter01.person.domain.Person;

public class PersonManagerService implements PersonManager {

	private static Logger logger = LoggerFactory.getLogger(PersonManagerService.class);
	static int count = 1;
	
	private PersonRepository personRepository;
	
	public PersonManagerService()
	{
		logger.info("Instance id " + count++);
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public boolean create(Person person) {

		logger.info("Creating person...");
		return personRepository.save(person);
	}
	
	public void printAll()
	{
		personRepository.printAll();
	}

}
