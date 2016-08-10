package Generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.*;

public class GenericCountProperties {
	
	public static void main(String args[])
	{
//		int howMany = howMany(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x % 2 != 1);
//		System.out.println("Number of odd numbers -> " + howMany);
//		
//		howMany = howMany(Arrays.asList("malayalam", "aba", "sri"), (x) -> x.equals(new StringBuffer(x).reverse().toString()));
//		System.out.println("Number of palindromes -> " + howMany);
//		
//		howMany = howMany(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x % 2 == 0);
//		System.out.println("Number of even numbers -> " + howMany);

		int howMany = howMany(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), new OddPredicate());
		System.out.println("Number of odd numbers -> " + howMany);
		
		howMany = howMany(Arrays.asList("malayalam", "aba", "sri"), new PalindromPredicate());
		System.out.println("Number of palindromes -> " + howMany);
		
		howMany = howMany(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x % 2 == 0);
		System.out.println("Number of even numbers -> " + howMany);

	}
	
	public static <T> int howMany(Collection<T> collection, UnaryPredicate<T> predicate)
	{
		int count = 0;
		
		for (T ele : collection)
		{
			if (predicate.test(ele)) count++;
		}
		
		return count;
	}

	static interface UnaryPredicate<T>
	{
		boolean test(T e);
	}
	
	static class OddPredicate implements UnaryPredicate<Integer>
	{
		@Override
		public boolean test(Integer e) {

			return (e % 2 != 0);
		}
	}
	
	static class PalindromPredicate implements UnaryPredicate<String>
	{
		@Override
		public boolean test(String e) {

			return e.equals(new StringBuffer(e).reverse().toString());
		}
	}

}
