package chapter01.person.dao;

import chapter01.person.domain.Person;

public interface PersonRepository {
	
	public boolean save(Person person);
	
	public void printAll();

}
