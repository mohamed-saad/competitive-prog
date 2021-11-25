package competitive.leetcode.easy.dp;

public class MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
    	int maxSum = nums[0];
    	int maxSumSoFar = nums[0];
    	for (int i=1; i<nums.length; i++) {
    		maxSumSoFar = Math.max(
    				maxSumSoFar + nums[i],	// option 1: take current 
    				nums[i]);				// option 2: start new sum
    		maxSum = Math.max(maxSum, maxSumSoFar);
    	}
        return maxSum;
    }
}
