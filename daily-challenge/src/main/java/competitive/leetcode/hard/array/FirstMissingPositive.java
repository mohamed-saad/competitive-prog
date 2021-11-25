package competitive.leetcode.hard.array;

public class FirstMissingPositive {
	
    public int firstMissingPositive(int[] nums) {
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	for (int i: nums) {
    		if (i <= 0) continue;
    		min = Math.min(min, i);
    		max = Math.max(max, i);
    	}
    	
    	if (min > 1) return 1;

    	for (int i=0; i<nums.length; i++)
    		if (nums[i] <= 1 || nums[i] > nums.length) 
    			nums[i] = 1;	// reset invalid numbers
    	
    	for (int i=0; i<nums.length; i++) {
    		int index = Math.abs(nums[i])-1;
    		nums[index] = Math.abs(nums[index]) * -1; 
    	}
    	
    	int i=0;
    	for (; i<nums.length; i++)
    		if (nums[i] > 0)
    			break;
    	
    	return i+1;
    }
    
    public static void main(String[] args) {
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] {1,2,2}));
	}
    
}
