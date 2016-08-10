package StringPrograms;

	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class Pangram {

	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	        Scanner s = new Scanner(System.in);

	    	String inputString = s.nextLine();
	    	
	        int alphabetCount = 26;
	        
	        Set<Character> hashSet = new HashSet<>();
	        
	   //Character.is
	        
//	        Character.toLowerCase(ch);
	        
        
	        for (int i = 0; i < inputString.length(); i++)
	        {
	        	if (!Character.isLetter(inputString.charAt(i)))
	        	continue;
	        	
	                if (!hashSet.contains(Character.toLowerCase(inputString.charAt(i))))
	                {
	                    hashSet.add(inputString.charAt(i));
	                    alphabetCount--;           
	                }
	                
	                if (alphabetCount == 0)
                        break;
	        }
	        
	        if(alphabetCount == 0)
	        {
	            System.out.println("pangram");    
	        }
	        else
	        {
	            System.out.println("not pangram");    
	        }
	        
	        s.close();
	    }
	}
