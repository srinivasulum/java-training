package Misc;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int number = s.nextInt();
		
		s.close();
		
		BigInteger big = new BigInteger("1");
		
		for (int i = number; i > 0; i--)
		{
			BigInteger temp = new BigInteger(String.valueOf(i));
			big = big.multiply(temp);
		}
		
		System.out.println(big.toString());
		
	}

}
