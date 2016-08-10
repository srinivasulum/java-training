package Misc;

import java.util.OptionalLong;
import java.util.Scanner;
import java.util.stream.LongStream;

public class TaumBday {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int a0 = 0; a0 < t; a0++){

            long black = in.nextLong();
            long white = in.nextLong();
            long blackCost = in.nextLong();
            long whiteCost = in.nextLong();
            long conversionCost = in.nextLong();
            long minimumCost = 0;
            
            OptionalLong max = LongStream.builder().add(blackCost).add(whiteCost).add(conversionCost).build().sequential().max();
            
            long maximumCost = max.getAsLong();
            
            if (maximumCost == conversionCost ||
            		(maximumCost == blackCost && ((whiteCost + conversionCost) > blackCost))
            		||(maximumCost == whiteCost && ((blackCost + conversionCost) > whiteCost)))
            {
            	minimumCost = (black * blackCost) + (white * whiteCost);
            }
            else if (maximumCost == blackCost)
            {
            	minimumCost = (white * whiteCost) + (black * (whiteCost + conversionCost));
            }
            else if (maximumCost == whiteCost)
            {
            	minimumCost = (black * blackCost) + (white * (blackCost + conversionCost));
            }
            
            System.out.println(minimumCost);
        }
        
        in.close();
    }
}
