package Misc;

import java.util.Arrays;
import java.util.Scanner;

public class TimeConversion {

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String _12HourFormat = s.nextLine();
		
		// remove PM or AM
		boolean isAM = _12HourFormat.endsWith("AM"); 
		
		String[] timeSplit = _12HourFormat.substring(0, _12HourFormat.length() - 2).split(":");
		
		int hour = Integer.parseInt(timeSplit[0]);
		
//		if (hour == 12 && isAM)
//		{
//			timeSplit[0] = "00";
//		}
//		else if (hour == 12 && !isAM)
//		{
//			timeSplit[0] = "12";
//		}
		if (isAM)
		{
			timeSplit[0] = String.format("%02d", hour % 12);
		}
		else if (!isAM)
		{
			timeSplit[0] = String.format("%02d", (hour % 12) + 12);
		}
		
		String _24HourFormat = String.join(":", timeSplit);

		System.out.println(_24HourFormat);
		
	}
}
