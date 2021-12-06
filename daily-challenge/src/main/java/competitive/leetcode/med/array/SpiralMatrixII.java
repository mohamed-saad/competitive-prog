package competitive.leetcode.med.array;

import java.util.Arrays;

public class SpiralMatrixII {
	
	public void fill(int from, int row, int col, int width, int[][] m) {
		if (width <=0) return;
		if (width == 1) {
			m[row][col] = from;
			return;
		}
		for (int i=0; i<width; i++)
			m[row][col+i] = from++;
		for (int i=1; i<width-1; i++)
			m[row+i][col+width-1] = from++;
		for (int i=0; i<width; i++)
			m[row+width-1][col+width-1-i] = from++;
		for (int i=1; i<width-1; i++)
			m[row+width-1-i][col] = from++;
		fill(from, row+1, col+1, width-2, m);
	}
	
    public int[][] generateMatrixSlow(int n) {
    	int[][] matrix = new int[n][n];
    	fill(1, 0, 0, n, matrix);
    	return matrix;
    }

    public int[][] generateMatrix(int n) {
    	int[][] m = new int[n][n];
    	for (int width=n, row=0, from = 1; width>=0; width-=2, row++) {
    		if (width == 1) {
    			m[row][row] = from;
    			break;
    		}
    		for (int i=0; i<width; i++)
    			m[row][row+i] = from++;
    		for (int i=1; i<width-1; i++)
    			m[row+i][row+width-1] = from++;
    		for (int i=0; i<width; i++)
    			m[row+width-1][row+width-1-i] = from++;
    		for (int i=1; i<width-1; i++)
    			m[row+width-1-i][row] = from++;
    	}
    	return m;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(6)));
		System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrixSlow(6)));

	}
    
}
