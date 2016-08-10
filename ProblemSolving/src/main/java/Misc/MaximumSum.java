package Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumSum {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int numberOfTestCases = in.nextInt();
		
		Map<Long, Long> cache = new HashMap<Long, Long>();
 		
		for (int i = 0; i < numberOfTestCases; i++)
		{
			int numberOfElements = in.nextInt();
			long modulo = in.nextLong();
			
			long[] array = new long[numberOfElements];
			long[] sumArray = new long[numberOfElements];
			long maxModuloSum = 0;

			boolean foundMaxModuloSum = false;

			for (int j = 0; j < numberOfElements; j++)
			{
				long nextLong = in.nextLong();
//				Long moduloNumber = cache.get(nextLong);
				array[j] = nextLong % modulo;
//
				sumArray[j] = array[j];
//
//				//System.out.println(sumArray[j]);
//				if (array[j] > maxModuloSum)
//				{
//					maxModuloSum = array[j];
//					
//					if (maxModuloSum == modulo - 1)
//					{
//						System.out.println(maxModuloSum);
//						foundMaxModuloSum = true;
//						break;
//					}
//				}
			}
			
			if (foundMaxModuloSum)
				continue;
			
			outerloop:
			for (int k = 1; k < numberOfElements; k++)
			{
				for (int l = 0; l < numberOfElements - k; l++)
				{
					Long moduloNumber = (sumArray[l] + array[k + l]) % modulo;
//					Long moduloNumber = cache.get(nextLong);
					//sumArray[l] = nextLong;// % modulo;
//
//					//sumArray[l] = (sumArray[l] + array[k + l]) % modulo;
//					//System.out.println(sumArray[l]);
//
//					if (sumArray[l] > maxModuloSum)
//					{
//						maxModuloSum = sumArray[l];
//						
//						if (maxModuloSum == modulo - 1)
//						{
//							break outerloop;
//						}
//					}						
				}
			}
			
			System.err.println(maxModuloSum);
		}
		
		in.close();
	}
}