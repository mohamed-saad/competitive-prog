package competitive.mit.subMatrixSumMax;

import java.util.HashMap;
import java.util.Map;

public class Solution implements FindSum{

	@Override
	public int findTargetSum(int[] array, int target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findTargetSum(int[][] matrix, int target) {
		int m = matrix.length; int n = matrix[0].length;
		
		for (int row=0; row<m; row++) {
			for(int col=1; col<n; col++) {
				matrix[row][col] += matrix[row][col-1];
			}
		}
		
		int count=0;
		for(int c1=0;c1<n;c1++) {
			for (int c2=c1; c2<n; c2++) {
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(0, 1);
				int sum = 0;
				
				for (int row=0; row<m; row++) {
					sum += matrix[row][c2] - (c1>0 ? matrix[row][c1-1] : 0);
					count += map.getOrDefault(sum-target,  0);
					map.put(sum,  map.getOrDefault(sum, 0)+1);
				}
				
				System.out.println("c1=" + c1 + " c2=" + c2 + " " + map);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().findTargetSum(
				new int[][] {
					{1, 2, 3},
					{4, 5, 6},
					{7, 8, 9},
				}
				, 12));
		
		System.out.println(new Solution().findTargetSum(
				new int[][] {
					{ 3 },
					{ 0 },
					{ 0 },
					{ -1 },
					{ 1 },
				}
				, 3));
		
		System.out.println(new Solution().findTargetSum(
				new int[][] {
					{3, 0, 0, -1, 1},
				}
				, 3));
		
	}
}
