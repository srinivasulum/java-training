package StringPrograms;

import java.util.Scanner;
import java.util.stream.IntStream;

public class StairCase {

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int numberOfStairs = s.nextInt();
		
		IntStream.range(1, numberOfStairs + 1).forEach(i -> {
			
			for (int j = 0; j < numberOfStairs - i; j++)
			{
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++)
			{
				System.out.print("#");
			}

			System.out.println();
			
		});
	}
}
