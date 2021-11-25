package competitive.leetcode.hard.array;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        
        // products from left to right
        out[0] = nums[0];	
        for (int i=1; i<nums.length; i++) 
        	out[i] = nums[i] * out[i-1];
        
        // products from right to left 
        for (int i=nums.length-2; i>=0; i--) 
        	nums[i] = nums[i] * nums[i+1];

        // find results
        for (int i=0; i<nums.length; i++)
        	nums[i] = (i==0 ? 1 : out[i-1]) * (i == nums.length-1 ? 1 : nums[i+1]);
        			
        return nums;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new ProductArrayExceptSelf().productExceptSelf(new int[] {1})));
	}
}
