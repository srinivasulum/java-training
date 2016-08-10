package StringPrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FindStrings {
	
	public static void main(String args[])
	{

		Scanner s = new Scanner(System.in);
		int numberOfStrings = s.nextInt();
		String a[] = new String[numberOfStrings];
		
		s.nextLine(); // to read new line
		
		for (int i = 0; i < numberOfStrings; i++)
		{
			a[i] = s.nextLine();
		}
		
		int numberOfQueries = s.nextInt();
		int query[] = new int[numberOfQueries];	

		for (int i = 0; i < numberOfQueries; i++)
		{
			query[i] = s.nextInt();
		}
		
		
		findStrings(a, query);
	}
	
	static void findStrings(String[] a, int[] query)
	{
		Set<String> uniqueStrings = Collections.synchronizedSet(new HashSet<>());
		
		List<String> asList = Arrays.asList(a);
		
		asList.parallelStream().forEach((input) ->	{	
			for (int j = 0; j < input.length(); j++)
			{
				for (int k = j + 1; k <= input.length(); k++)
				{
					uniqueStrings.add(input.substring(j, k));
				}
			}
		});
		
		Set<String> sortedSet = new TreeSet<String>(uniqueStrings);
		String[] stringArray = sortedSet.toArray(new String[0]);
		
		for (int i = 0; i < query.length; i++)
		{
			if (query[i] > stringArray.length)
			{
				System.out.println("INVALID");
			}
			else
			{
				System.out.println(stringArray[query[i] - 1]);
			}
		}
		
	}
}
