package competitive.mit.subMatrixSumMax;

public class MaxSubArray implements FindMax{

	@Override
	public int findMaxSum(int[] array) {
		
		int max = array[0];
		int sumSoFar = array[0];
		for (int i=1; i<array.length; i++) {
			sumSoFar = Math.max(array[i] + sumSoFar, array[i]); 
			max = Math.max(max, sumSoFar);
		}
		
		return max;
	}
	
	@Override
	public int findMaxSum(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = Integer.MIN_VALUE;
		for (int c1 = 0; c1 < cols; c1++) {
			int[] runningSum = new int[rows];
			for (int c2=c1; c2 < cols; c2++) {
				for (int r=0; r<rows; r++) {
					runningSum[r] += matrix[r][c2];
				}
				max = Math.max(max, findMaxSum(runningSum));
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxSubArray().findMaxSum(new int[] { -2, -1, 5, -4, 6, 3, 1, -7, 8, 1, -4 }));
		System.out.println(new MaxSubArray().findMaxSum(new int[][] {
			{ 1,   2, -3,  4 },
			{ -5, -2,  -8, -4 },
			{ 1,   2, -3,  4 },
		}));
	}
	
	
}
