package chapter01.person.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chapter01.person.domain.Person;

public class PersonRepositoryImpl implements PersonRepository {

	private static Logger logger = LoggerFactory.getLogger(PersonRepositoryImpl.class);

	List<Person> dataSource;

	public void setDataSource(List<Person> dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean save(Person person) {

		boolean added = dataSource.add(person);
		
		logger.info("Persisted person {} ", person);
		logger.info("Persisted Status {}", added);

		return added;
	}
	
	public void printAll() {
		
		logger.info("Listing all the person");

		for (Person p : dataSource)
		{
			logger.info("{}",p);
		}
	}

}
