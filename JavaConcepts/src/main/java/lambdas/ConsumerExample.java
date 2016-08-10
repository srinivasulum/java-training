package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class ConsumerExample {
	
	public static void main(String args[])
	{
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);
		
		// Print all the number in the list
		System.out.println("Print all the number in the list");
		forEach(asList, (Integer x) -> System.out.print(x + " "));
		
		//Print only Even Numbers
		System.out.println();
		System.out.println("Print Even numbers in the list");
		forEach(
				forEach(asList, (Integer x) -> x % 2 == 0),
				(Integer x) -> print(x));

		System.out.println();
		System.out.println("Print Odd numbers in the list");
		forEach(
				forEach(asList, (Integer x) -> x % 2 == 1), (Consumer<Integer>) ConsumerExample::print);
		
		List<String> strList = Arrays.asList("Haskell", "java", "scala", "groovy", "c#");

		System.out.println();
		System.out.println("Converting List of Strings to List of String length");
		forEach(map(strList, (String x) -> x.length()),
				(Consumer<Integer>) ConsumerExample::print);
	}
	
	public static <T> void print(T ele)
	{
		System.out.print(ele + " ");
	}

	public static <T> void forEach(List<T> list, Consumer<T> operation)
	{
		for (T ele : list)
		{
			operation.accept(ele);
		}
	}
	
	public static <T> List<T> forEach(List<T> list, Predicate<T> predicate)
	{
		List<T> newList = new ArrayList<T>();

		for (T ele : list)
		{
			if (predicate.test(ele))
			{
				newList.add(ele);
			}
		}
		return newList;
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> function)
	{
		List<R> newList = new ArrayList<R>();

		for (T ele : list)
		{
			newList.add(function.apply(ele));
		}

		return newList;
	}
}
