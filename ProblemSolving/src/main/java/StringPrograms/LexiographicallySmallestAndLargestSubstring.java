package StringPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LexiographicallySmallestAndLargestSubstring {
	
	public static Set<Character> vowelSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	
	public static void main(String args[])
	{
		String inputString = "aab";
		List<Integer> vowelIndices = new ArrayList<>();
		List<Integer> constantIndices = new ArrayList<>();
	
		for (int i = 0; i < inputString.length(); i++)
		{
			boolean added = (vowelSet.contains(inputString.charAt(i)))?
					vowelIndices.add(i) : constantIndices.add(i);
		}
		
		String smallestSubString = "";
		String largestSubString = "";

		for (Integer vowelIndex : vowelIndices)
		{
			for (Integer constanstIndex: constantIndices)
			{
				if (constanstIndex <= vowelIndex) continue;
				
				String runningSubString = inputString.substring(vowelIndex, constanstIndex + 1);
				//System.out.println("["+ inputString.substring(vowelIndex, constanstIndex + 1) + "]");
				
				if (smallestSubString.isEmpty() && largestSubString.isEmpty())
				{
					smallestSubString = largestSubString = runningSubString;
					continue;
				}

				int smallestcompareTo = smallestSubString.compareTo(runningSubString);
				int largestcompareTo = largestSubString.compareTo(runningSubString);

				if (smallestcompareTo > 0)
				{
					smallestSubString = runningSubString;
				}
				
				if (largestcompareTo < 0)
				{
					largestSubString = runningSubString;
				}
			}
		}
		
		System.out.println("Smallest substring " + smallestSubString);
		System.out.println("Largest substring " + largestSubString);

	}

}
 