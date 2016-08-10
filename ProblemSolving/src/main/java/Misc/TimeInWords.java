package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TimeInWords {

	private static Map<Integer, String> timeMap = new HashMap<>();
	private static Map<Integer, String> wordMap = new HashMap<>();
	
	private static final String PAST = "past";
	private static final String TO = "to";
	private static final String MINUTE = "minute";
	private static final String MINUTES = "minutes";
	private static final String HALF_PAST = "half past";
	private static final String QUARTER_PAST = "quarter past";
	private static final String QUARTER_TO = "quarter to";
	private static final String OCLOCK = "o' clock";
	private static final String SPACE = " ";
	
	static
	{
		timeMap.put(1, "one");
		timeMap.put(2, "two");
		timeMap.put(3, "three");
		timeMap.put(4, "four");
		timeMap.put(5, "five");
		timeMap.put(6, "six");
		timeMap.put(7, "seven");
		timeMap.put(8, "eight");
		timeMap.put(9, "nine");
		timeMap.put(10, "ten");
		timeMap.put(11, "eleven");
		timeMap.put(12, "twelve");
		timeMap.put(13, "thirteen");
		timeMap.put(14, "fourteen");
		timeMap.put(15, "fifteen");
		timeMap.put(16, "sixteen");
		timeMap.put(17, "seventeen");
		timeMap.put(18, "eighteen");
		timeMap.put(19, "nineteen");
		timeMap.put(20, "twenty");
		timeMap.put(30, "thirty");
		timeMap.put(40, "fourty");
		timeMap.put(50, "fifty");
		
		wordMap.put(0, OCLOCK);
		wordMap.put(15, QUARTER_PAST);
		wordMap.put(30, HALF_PAST);
		wordMap.put(45, QUARTER_TO);
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int hour = in.nextInt();
		int minute = in.nextInt();
		List<String> timeInWords = new ArrayList<>();
		
		if (wordMap.get(minute) != null)
		{
			switch(wordMap.get(minute))
			{
			case OCLOCK:
				timeInWords.add(timeMap.get(hour));
				timeInWords.add(wordMap.get(minute));
				break;

			case QUARTER_PAST:
			case HALF_PAST:
				timeInWords.add(wordMap.get(minute));
				timeInWords.add(timeMap.get(hour));
				break;

			case QUARTER_TO:
				timeInWords.add(wordMap.get(minute));
				timeInWords.add(timeMap.get(hour + 1));
				break;
			}
		}
		else
		{	
			int effectiveminutes = minute;

			if (minute > 30)
				effectiveminutes = 60 - minute;

			if (effectiveminutes > 20)
			{
				timeInWords.add(timeMap.get((effectiveminutes/10) * 10));
			
				if (effectiveminutes % 10 != 0)
				{
					timeInWords.add(timeMap.get(effectiveminutes % 10));
				}
			}
			else
			{
				timeInWords.add(timeMap.get(effectiveminutes));
			}

			timeInWords.add((effectiveminutes > 1)?  MINUTES : MINUTE); 
			timeInWords.add((minute > 30)? TO : PAST);
			timeInWords.add((minute > 30)? timeMap.get(hour + 1) : timeMap.get(hour));
		}
		
		String.join(SPACE, timeInWords);

		System.out.println(String.join(SPACE, timeInWords));
		
		in.close();
	}
}
