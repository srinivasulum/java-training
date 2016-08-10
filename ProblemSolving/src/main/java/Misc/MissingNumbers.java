package Misc;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MissingNumbers {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		Map<Integer, Integer> data = new TreeMap<Integer, Integer>();
		
		//List A
		int listASize = in.nextInt();
		for (int i = 0; i < listASize; i++)
		{
			int number = in.nextInt();
			
			Integer count = data.get(number);
			
			if (count == null)
			{
				data.put(number, 1);
			}
			else
			{
				data.put(number, ++count);
			}	
		}
		
		//List B
		int listBSize = in.nextInt();
		for (int i = 0; i < listBSize; i++)
		{
			int number = in.nextInt();
			
			Integer count = data.get(number);
			
			if (count == null)
			{
				data.put(number, -1);
			}
			else
			{
				if (count >= 0)
				{
					data.put(number, --count);
				}
			}	
		}
		
		for (Entry<Integer, Integer> missingEntry : data.entrySet())
		{
			if (missingEntry.getValue() < 0)
			{
				System.out.println(missingEntry.getKey());
			}
		}

		in.close();
	}
}
