package competitive.leetcode.easy.array;

import java.util.Arrays;

public class RotateArray {
	
    public void rotate(int[] nums, int k) {
    	k = k % nums.length;
    	if (k == 0) return;
    	int[] backup = new int[k];
    	int overflowIndex = nums.length-k;
    	for (int i=0; i<backup.length; i++) {
    		backup[i] = nums[overflowIndex+i];
    	}
    	for (int i=nums.length-1; i>=k; i--) {
    		nums[i] = nums[i-k];
    	}
    	for (int i=0; i<backup.length; i++) {
    		nums[i] = backup[i];
    	}
    }
    
    public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		new RotateArray().rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

}
