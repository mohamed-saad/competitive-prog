package competitive.mit.subMatrixSumMax;

import java.util.HashMap;
import java.util.Map;

public class SumSubArray  implements FindSum{
	
	public int findTargetSum(int[] array, int target) {
		
		int count = 0;
		
		Map<Integer, Integer> sumsCounts = new HashMap<>();
		int runningSum = 0;
		sumsCounts.put(0, 1);
		for (int i=0; i<array.length; i++) {
			runningSum += array[i];
			
			Integer seen = sumsCounts.get(runningSum - target);
			if (seen != null) count += seen;
			
			sumsCounts.put(runningSum, sumsCounts.getOrDefault(runningSum, 0)+1);
		}
		
		return count;
	}

	@Override
	public int findTargetSum(int[][] matrix, int target) {
		int count = 0;
		
		int rows = matrix.length; int cols = matrix[0].length;
		
		for (int row1=0; row1<rows; row1++) {
			int[] array = new int[cols];
			for (int row2=row1; row2<rows; row2++) {
				for (int c=0; c<cols; c++) {
					array[c] += matrix[row2][c];
				}
				count += findTargetSum(array, target);
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new SumSubArray().findTargetSum(new int[] { 3,  0, 0, -1, 1 }, 3));
		
		System.out.println(new SumSubArray().findTargetSum(new int[] { 3, 4, 7, 2, -3, 1, 4, 2 }, 7));
		
		System.out.println(new SumSubArray().findTargetSum(
			new int[][] {
				{1, 2, 3},
				{4, 5, 9},
				{7, 8, 3},
			}
			, 12));
	}
}
