package chapter01.person.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import chapter01.person.dao.PersonRepository;
import chapter01.person.dao.PersonRepositoryImpl;
import chapter01.person.domain.Person;
import chapter01.person.service.PersonManager;
import chapter01.person.service.PersonManagerService;

@Configuration
@PropertySource("classpath:person/persons.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean(name = "personService") // name = "value" is not required, By default spring derives names from the method name
	public PersonManager getPersonService()
	{
		PersonManager personManager = new PersonManagerService();
		((PersonManagerService)personManager).setPersonRepository(getPersonRepository());
		return personManager;
	}

	@Bean(name = "personRepository")
	public PersonRepository getPersonRepository() {
		PersonRepository repo = new PersonRepositoryImpl();
		List<Person> list = new ArrayList<>();
		list.add(getPerson());
		((PersonRepositoryImpl)repo).setDataSource(list);
		return repo;
	}
	
	@Bean(name = "person")
	public Person getPerson() {
		Person p = new Person(env.getProperty("firstname"), env.getProperty("lastname"), env.getProperty("dob"));
		return p;
	}
}
