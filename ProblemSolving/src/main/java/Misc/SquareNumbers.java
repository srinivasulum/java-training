package Misc;

import java.util.Scanner;

public class SquareNumbers {
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int numberOfTestCase = s.nextInt();
		
		for (int i = 0; i < numberOfTestCase; i++)
		{
			int startNumber = s.nextInt();
			int endNumber = s.nextInt();
			
			double sqrt1 = Math.floor(Math.sqrt(startNumber));
			double sqrt2 = Math.ceil(Math.sqrt(endNumber));
			
			int count = 0;
			for (;sqrt1 <= sqrt2;sqrt1++)
			{
				double pow = Math.pow(sqrt1, 2);
				if (pow >= startNumber && pow <= endNumber)
				{
					++count;
				}
			}
			
			System.out.println(count);
		}
		
		s.close();
	}

}
