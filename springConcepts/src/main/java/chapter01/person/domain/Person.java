package chapter01.person.domain;

public class Person {
	
	String firstName;
	String lastName;
	String dob;
	
	public Person()
	{
	}

	public Person(String fistName, String lastName, String dob) {
		super();
		this.firstName = fistName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString()
	{
		return "I am " + firstName + " " + lastName + " born on " + dob;
	}
}
