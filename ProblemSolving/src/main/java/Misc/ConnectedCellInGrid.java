package Misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ConnectedCellInGrid {
		
	private enum Direction
	{
		E (+0, +1),
		W (+0, -1),
		N (-1, +0),
		S (+1, +0),
		NE(-1, +1),
		NW(-1, -1),
		SE(+1, +1),
		SW(+1, -1);
		
		private int rowAdj = 0;
		private int colAdj = 0;
		
		Direction(int row, int col)
		{
			rowAdj = row;
			colAdj = col;
		}

		public int getRowAdj() {
			return rowAdj;
		}

		public int getColAdj() {
			return colAdj;
		}
		
		public boolean isRowAdjNegative()
		{
			return (rowAdj < 0);
		}
		
		public boolean isColAdjNegative()
		{
			return (colAdj < 0);
		}
		
		public boolean isRowAdjPositive()
		{
			return (rowAdj > 0);
		}
		
		public boolean isColAdjPositive()
		{
			return (colAdj > 0);
		}

	}
	
	private static class Cell
	{
		private int row;
		private int col;
		boolean isVisited = false;
		
		public Cell(int row, int col)
		{
			this.row = row;
			this.col = col;
		}

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}
		
		public void setVisited(boolean isVisited)
		{
			this.isVisited = isVisited;
		}
		
		@Override
	    public String toString() {
	    	return "(" + row + "," + col + ")";
	    }
		
		@Override
		public int hashCode()
		{
			return row + col; //row + col is unique id. Safe :)
		}
		
		@Override
	    public boolean equals(Object obj) {
	        Cell cell = (Cell) obj;
	        return ((this.row == cell.row) && (this.col == cell.col));
	    }
	}

	private static Set<Cell> regions = new HashSet<>();
	private static int rows = 0;
	private static int cols = 0;

	/**
	 * @param args
	 */
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int rows = in.nextInt();
		int cols = in.nextInt();
		
		// Read Matrix and store the regions into the set
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				int number = in.nextInt();
				
				if (number == 1)
				{
					regions.add(new Cell(i, j));
				}
			}
		}
		
		//Find max region length
		int maxRegionLength = 0;
		while(regions.iterator().hasNext())
		{
			Cell startRegion = regions.iterator().next();

			int findRegionLength = findRegionLength(startRegion);
			
			if (findRegionLength > maxRegionLength)
			{
				maxRegionLength = findRegionLength;
			}
		}
		
		System.out.println(maxRegionLength);
		
		in.close();
	}
	
	private static int findRegionLength(Cell startRegion) {

		Stack<Cell> stack = new Stack<Cell>();
		
		startRegion.setVisited(true);
		regions.remove(startRegion);
		stack.push(startRegion);
		int regionLength = 1;
		
		while (!stack.isEmpty())
		{
			Cell peek = stack.peek();
			Cell nextVisingCell = getUnvisitedCell(peek);
			
			if (nextVisingCell == null)
			{
				stack.pop();
			}
			else
			{
				nextVisingCell.setVisited(true);
				regions.remove(nextVisingCell);
				stack.push(nextVisingCell);
				regionLength++;
			}
		}

		return regionLength;
	}
	
	static Cell getUnvisitedCell(Cell cell)
	{
		List<Cell> adjacentCells = getAdjacentCells(cell, rows, cols);
		
		for (Cell cellInfo : adjacentCells)
		{
			if (regions.contains(cellInfo)) return cellInfo;
		}
		
		return null;
	}

	static List<Cell> getAdjacentCells(Cell cell, int maxRow, int maxCol)
	{
		Direction[] values = Direction.values();
		List<Cell> adjacentCells = new ArrayList<>();
		
		int row = cell.getRow();
		int col = cell.getCol();

		for (Direction direction : values)
		{
			if (row == 0 && direction.isRowAdjNegative()) continue;
			if (col == 0 && direction.isColAdjNegative()) continue;
			if (row == (maxRow - 1) && direction.isRowAdjPositive()) continue;
			if (col == (maxCol - 1)  && direction.isColAdjPositive()) continue;
			
			//System.out.println("( " + (row + direction.getRowAdj()) + "," + (col + direction.getColAdj()) + " )" );
			
			adjacentCells.add(new Cell(row + direction.getRowAdj(), col + direction.getColAdj()));
		}
		
		return adjacentCells;
	}

}
