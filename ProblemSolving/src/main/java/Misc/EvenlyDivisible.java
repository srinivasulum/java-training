package Misc;

import java.util.Scanner;

public class EvenlyDivisible {
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int numberOfTestCases = s.nextInt();
		
		for (int i = 0; i < numberOfTestCases; i++)
		{
			int number = s.nextInt();
		
			System.out.println(findEvenlyDivisible(number));
			
		}
		
		s.close();
	}
	
	static int findEvenlyDivisible(int number)
	{
		int count = 0;
		
		String str = Integer.toString(number);
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++)
		{
			int n = Integer.parseInt(String.valueOf(charArray[i]));
			if (charArray[i] == '0')
			{
				continue;
			}

			int remainder = number % n;
			
			if (remainder == 0)
				count++;
		}
		
		return count;
	}

}
