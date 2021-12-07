package competitive.leetcode.med.array;

import java.util.Arrays;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
    	int count = 0;
    	
    	for (int start=0; start<nums.length; start++) {
    		int sum = nums[start];
    		if (sum == k) count++;
    		for (int end=start+1; end<nums.length; end++) {
    			sum += nums[end];
    			if (sum == k) count++;
    		}
    	}
    	
    	return count;
    }
    
    public static void main(String[] args) {
    	int[][] tests = {
    			{1,1,1},
    			{1,2,3},
    			{1,2,3,-2,-1},
    			{1,2,4,-2,-1},
    	};
    	for (int i=0; i<tests.length; i++) {
    		System.out.println(new SubarraySumEqualsK().subarraySum(tests[i], 3) + "\t" + Arrays.toString(tests[i]));
    	}
	}
    
}
