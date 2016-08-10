package StringPrograms;

public class StringPermutations {
	
	private static final int FIRST_INDEX = 0;
	private static int count = 0;

	public static void main(String args[])
	{
		String input = "abcefghijk";

		System.out.println("Computing permutations for [ " + input + " ]");
		permute(input);
		System.out.println("Total number of permutations found for [ " + input + " ] : " + count);
	}
	
	private static void permute(String inputString)
	{
		permute("", inputString);
	}
	
	private static void permute(String prefix, String inputString)
	{
		if (inputString.length() == 1)
		{
			//print when you reach to single character
			System.out.println(prefix + inputString);
			count++;
		}
		
		for (int index = 0; index < inputString.length(); index++)
		{
			//swap first position character
			char[] permuteInputString = inputString.toCharArray();
			char t = permuteInputString[FIRST_INDEX];
			permuteInputString[FIRST_INDEX] = permuteInputString[index];
			permuteInputString[index] = t;
			
			inputString = String.valueOf(permuteInputString);
			
			permute(prefix + String.valueOf(inputString.charAt(0)), inputString.substring(1));
		}
	}
}
