package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindingMax {
	
	static int[] array = new int[] {1,2,4,8,9,10,76};
	
	public static void main(String args[])
	{
		//Arrays.parallelStream(array).max().ifPresent(System.out::println);
		
		Arrays.stream(array).max().ifPresent(System.out::println);
		
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		// Print numbers less than 5
		Arrays.stream(array).filter(s -> s < 5).forEach(System.out::println);
	}

}
