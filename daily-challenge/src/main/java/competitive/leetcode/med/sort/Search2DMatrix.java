package competitive.leetcode.med.sort;

public class Search2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		// search in first col
		int top = 0;
		int bottom = matrix.length - 1;
		while (top <= bottom) {
			int mid = (top + bottom)/2;
			if (target < matrix[mid][0])
				bottom = mid - 1;
			else if (target > matrix[mid][0])
				top = mid + 1;
			else
				return true;	// found it
		}
		
		int closest = bottom;
		if (closest < 0) return false;
		
		int left = 0;
		int right = matrix[0].length - 1;
		while (left <= right) {
			int mid = (left + right)/2;
			if (target < matrix[closest][mid])
				right = mid - 1;
			else if (target > matrix[closest][mid])
				left = mid + 1;
			else
				return true;	// found it
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[][] matrix = 
			{{1,3,5,7},
			 {10,11,16,20},
			 {21,21,21,22},
			 {23,30,34,60}};
		System.out.println(new Search2DMatrix().searchMatrix(matrix, 20));
	}
}
