package competitive.leetcode.med.sort;

public class Search2DMatrixII {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int col = matrix[0].length-1;
		int row = 0;
		
		while (col >= 0 && row < matrix.length) {
			if (target > matrix[row][col]) {
				row++;	// go to next row
			} else if (target < matrix[row][col]) {
				col--;	// go to prev col
			} else {
				return true;
			}
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = 
			{{1,4,7,11,15},
			 {2,5,8,12,19},
			 {3,6,9,16,22},
			 {10,13,14,17,24},
			 {18,21,23,26,30}};
		System.out.println(new Search2DMatrixII().searchMatrix(matrix, 1));
	}
}
