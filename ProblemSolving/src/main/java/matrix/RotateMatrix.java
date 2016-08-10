package matrix;

import java.util.Scanner;

public class RotateMatrix {
	
	public static void main(String args[])
	{    

		Scanner s = new Scanner(System.in);
		
		int row = s.nextInt();
		int col = s.nextInt();
		int numberOfRotations = s.nextInt();
		int[][] matrix = new int[row][col];
		
		// read matrix
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				matrix[i][j] = s.nextInt();
			}
		}
		
		
		// Number of tracks to rotate
		int numberOfTracks = (int) Math.ceil((double)Math.min(row, col) /(double) 2);
		
		//System.out.println("Number of Tracks: " + numberOfTracks);
		
		int rowN = row;
		int colN = col;
		
		for (int level = 0; level < numberOfTracks; level++)
		{

			int numberOfElements = (rowN * colN) - ((rowN - 2) * (colN - 2)); 

			int effectiveNumberOfRotations = numberOfRotations;
			if (numberOfRotations > numberOfElements)
			{
				effectiveNumberOfRotations = effectiveNumberOfRotations % numberOfElements;
			}

			for (int iteration = 0; iteration < effectiveNumberOfRotations; iteration++)
			{
				int runningRow = level;
				int runningCol = level;
				int minRow = level;
				int minCol = level;
				int maxRow = row - level;
				int maxCol = col - level;
				int temp;

				int startingNumber = matrix[runningRow][runningCol];

				//RIGHT
				for (;runningCol < maxCol - 1; runningCol++)
				{
					temp = matrix[runningRow][runningCol + 1];
					matrix[runningRow][runningCol] = temp;
				}

				//DOWN
				for (;runningRow < maxRow - 1; runningRow++)
				{
					temp = matrix[runningRow + 1][runningCol];
					matrix[runningRow][runningCol] = temp;
				}				

				//LEFT
				for (;runningCol > minCol; runningCol--)
				{
					temp = matrix[runningRow][runningCol - 1];
					matrix[runningRow][runningCol] = temp;
				}

				//UP
				for (;runningRow > minRow + 1; runningRow--)
				{
					temp = matrix[runningRow - 1][runningCol];
					matrix[runningRow][runningCol] = temp;
				}
		
				
				matrix[runningRow][runningCol] = startingNumber;
	
			}
            
          rowN -= 2;
		  colN -= 2;
		}
		
		// Print matrix
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		


	
	}

}
