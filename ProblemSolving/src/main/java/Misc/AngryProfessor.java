package Misc;

import java.util.Scanner;

public class AngryProfessor {
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int numberOfTestCases = s.nextInt();
		
		for (int i = 0; i < numberOfTestCases; i++)
		{
			int numberOfStudents = s.nextInt();
			int threshold = s.nextInt();

			int students;

			int count = 0;
			for (int j = 0; j < numberOfStudents; j++)
			{
				students = s.nextInt();
				
				if (students <= 0)
				{
					++count;
				}
			}
			
			if (threshold == 0 || count >= threshold)
			{
				System.out.println("NO");
			}
			else if (count < threshold)
			{
				System.out.println("YES");
			}
		}
	}

}
