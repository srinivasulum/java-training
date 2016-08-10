package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
	
	static class Person
	{
		int id;
		String name;
		int age;
		
		public Person(int id, String name, int age) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
		}

		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
		
		@Override
		public String toString()
		{
			return name;
		}
	}
	
	public static void main(String args[])
	{
		List<Person> list = Arrays.asList(new Person(1, "srini", 25), new Person(2, "foo", 35), new Person(3, "bar", 45));
		
		Map<Integer, Person> collect = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		System.out.println(collect);
	}

}
