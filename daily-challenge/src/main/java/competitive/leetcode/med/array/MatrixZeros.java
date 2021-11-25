package competitive.leetcode.med.array;

import java.util.Arrays;

public class MatrixZeros {
	
	private static final int NONE = -1;
	private static final int EMPTY = 1000;
    public void setZeroes(int[][] matrix) {
    	
    	int zeroRow = NONE;
    	int zeroCol = NONE; 
    	
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int r=0; r<rows; r++) {
        	if (r == zeroRow) continue;
        	for (int c=0; c<cols; c++) {
            	if (c == zeroCol) continue;
        		if (matrix[r][c] == 0) {
        			if (zeroRow == NONE) {
        				zeroRow = r;
        				zeroCol = c;
        				
        				// reset values
        				for (int i=0; i<rows; i++)
        					if (matrix[i][zeroCol] != 0)
        						matrix[i][zeroCol] = EMPTY;
        				for (int i=0; i<cols; i++)
        					if (matrix[zeroRow][i] != 0)
        						matrix[zeroRow][i] = EMPTY;
        			}
        			
        			matrix[zeroRow][c] = 0;
        			matrix[r][zeroCol] = 0;
        		}
        	}
        }
        
        if (zeroRow != NONE) {
            for (int c=0; c<cols; c++) {
            	if (matrix[zeroRow][c] == 0) {
            		// reset this column
            		for (int r=0; r<rows; r++) {
                    	if (c == zeroCol || r == zeroRow) continue;
            			matrix[r][c] = 0; 
            		}
            	}
            }
            
            for (int r=0; r<rows; r++) {
            	if (matrix[r][zeroCol] == 0) {
            		// reset this row
            		for (int c=0; c<cols; c++) {
                    	if (c == zeroCol || r == zeroRow) continue;
            			matrix[r][c] = 0; 
            		}
            	}
            }
            
			for (int i=0; i<rows; i++)
					matrix[i][zeroCol] = 0;
			for (int i=0; i<cols; i++)
					matrix[zeroRow][i] = 0;
        }
    
    }
    
    public static void main(String[] args) {
//    	int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    	int[][] matrix = new int[][] {{0,1,2,1},{3,4,0,2},{1,3,1,5}};
//    	int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
    	new MatrixZeros().setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}
