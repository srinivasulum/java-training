package chapter01.person.service;

import chapter01.person.domain.Person;

public interface PersonManager {
	
	public boolean create (Person person);
	
	public void printAll();
}
