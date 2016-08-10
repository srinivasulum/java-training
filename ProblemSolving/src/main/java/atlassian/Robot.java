package atlassian;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Robot {

	private static final int NUMBER_POSITIONS = 10;
	private static final Integer MAX_BLOCKS_PER_POSITION = 15;
	private static Map<Integer, Integer> positionMap = new TreeMap<>();

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String commandInput = s.nextLine();
		
		char[] commandArray = commandInput.toCharArray();

		for (int i = 0; i < NUMBER_POSITIONS; i++)
		{
			positionMap.put(i, 0);
		}
		
		int position = 0;
		boolean blockPicked = false;
		for (int i = 0; i < commandArray.length; i++ )
		{
			switch(commandArray[i])
			{
				case 'P':
					blockPicked = true;
					position = 0;
					break;
				case 'M':
					if (position < NUMBER_POSITIONS - 1)
					{
						position++;
					}
					break;
				case 'L':
					if (blockPicked)
					{
						Integer positionBlockCount = positionMap.get(position);
						
						if (positionBlockCount < MAX_BLOCKS_PER_POSITION - 1)
						{
							positionMap.put(position, ++positionBlockCount);
							blockPicked = false;
						}
					}
					break;
			}
		}
		
		for (Integer positionBlockCount : positionMap.values())
		{
			System.out.print(Integer.toHexString(positionBlockCount).toUpperCase());
		}
	}
}
