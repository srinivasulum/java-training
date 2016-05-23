package percentage;

public class PercentCalc {
	
	public static void main(String args[])
	{
		long total = 535293952;
		long remaining = 11005952;

		long percent = (long) (((float)remaining / (float) total) * 100);
		
		System.out.println("Percent " + percent);

	}

}
