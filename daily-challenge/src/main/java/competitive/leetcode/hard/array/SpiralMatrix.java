package competitive.leetcode.hard.array;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
	
	private void spiral(int[][] matrix, List<Integer> output, int startRow, int startCol, int endRow, int endCol) {
		if (endRow < startRow || endCol < startCol) return;
		for (int i=startCol; i<=endCol; i++) 
			output.add(matrix[startRow][i]);
		for (int i=startRow+1; i<=endRow; i++)
			output.add(matrix[i][endCol]);
		if (startRow != endRow)
			for (int i=endCol-1; i>=startCol; i--) 
				output.add(matrix[endRow][i]);
		if (startCol != endCol)
			for (int i=endRow-1; i>startRow; i--)
				output.add(matrix[i][startCol]);
		spiral(matrix, output, startRow+1, startCol+1, endRow-1, endCol-1);
		
	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> output = new LinkedList<>();
    	spiral(matrix, output, 0, 0, matrix.length-1, matrix[0].length-1);
    	return output;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = new int[][] {
    		{1,2,3,4},
    		{5,6,7,8},
    		{9,10,11,12},
    		{13,14,15,16}};
//    	int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//    	int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//    	int[][] matrix = new int[][] {{1},{2},{3},{4}};

		System.out.println(new SpiralMatrix().spiralOrder(matrix));
	}

}
