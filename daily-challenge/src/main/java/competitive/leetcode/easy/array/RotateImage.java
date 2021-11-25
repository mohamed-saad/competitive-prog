package competitive.leetcode.easy.array;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
    	int rows = matrix.length;
    	for (int r = 0; r < rows; r++) { 
    		for (int c = 0; c < rows-r-1; c++) {
    			int temp = matrix[r][c];
    			matrix[r][c] = matrix[rows-c-1][rows-r-1];
    			matrix[rows-c-1][rows-r-1] = temp;
    		}
    	}
    	
    	for (int c=0; c<rows; c++) {
    		for (int r=0; r<rows/2; r++) {
    			int temp = matrix[r][c];
    			matrix[r][c] = matrix[rows-r-1][c];
    			matrix[rows-r-1][c] = temp;
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[][] matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//    	int[][] matrix = new int[][]  {{1,2,3},{4,5,6},{7,8,9}};

    	new RotateImage().rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}
