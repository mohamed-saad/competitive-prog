package competitive.leetcode.easy.design;

import java.util.Arrays;

public class ShuffleArray {

	private final int[] nums;
	private final int[] clone; 
    public ShuffleArray(int[] nums) {
        this.nums = nums;
        clone = nums.clone();
    }
    
    public int[] reset() {
    	System.arraycopy(clone, 0, nums, 0, clone.length);
        return nums;
    }
    
    public int[] shuffle() {
    	for (int i=0; i<nums.length; i++) {
    		int index = (int)(Math.random()*nums.length);
    		int temp = nums[0];
    		nums[0] = nums[index];
    		nums[index] = temp;
    	}
        return nums;
    }
    
    public static void main(String[] args) {
//    	int[] nums = new int[200];
//    	for (int i=0; i<nums.length; i++)
//    		nums[i] = i;
    	int[] nums = new int[] {-6,10,18};
    	ShuffleArray s = new ShuffleArray(nums);
    	System.out.println("reset:" + Arrays.toString(s.reset()));
    	System.out.println("shuff:" + Arrays.toString(s.shuffle()));
    	System.out.println("reset:" + Arrays.toString(s.reset()));
    	System.out.println("shuff:" + Arrays.toString(s.shuffle()));
    	System.out.println("reset:" + Arrays.toString(s.reset()));

	}
    
}
