package Misc;

import java.util.Scanner;

public class UtophiaTree {
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int numberOfTestCases = s.nextInt();
		
		for (int i = 0; i < numberOfTestCases; i++)
		{
			int numberOfCycles = s.nextInt();
			int height = 1;

			boolean isSpring = true;
			for (int j = 0; j < numberOfCycles; j++)
			{
				if (isSpring)
				{
					height = height * 2;
					isSpring = false;
					continue;
				}
				else
				{
					height = height + 1;
					isSpring = true;
					continue;
				}
			}
			
			System.out.println(height);
		}
		
		s.close();
	}

}
