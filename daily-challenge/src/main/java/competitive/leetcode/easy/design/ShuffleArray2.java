package competitive.leetcode.easy.design;

import java.util.Arrays;

public class ShuffleArray2 {

	private final int[] nums;
	private final byte[] steps; 
	private boolean shuffled;
    public ShuffleArray2(int[] nums) {
        this.nums = nums;
        steps = new byte[nums.length];
    }
    
    public int[] reset() {
        if (shuffled) {
        	for (int i=steps.length-1; i>=0; i--) {
        		int temp = nums[0];
        		int index = steps[i] < 0 ? steps[i]+128 : steps[i];
        		nums[0] = nums[index]; 
        		nums[index] = temp;
    		}
        	shuffled = false;
        }
        return nums;
    }
    
    public int[] shuffle() {
        reset();
        for (int i=0; i<steps.length; i++) {
        	steps[i] = (byte)(Math.random() * nums.length);
        	int temp = nums[0];
    		int index = steps[i] < 0 ? steps[i]+128 : steps[i];
    		nums[0] = nums[index]; 
    		nums[index] = temp;
        }
        shuffled = true;
        return nums;
    }
    
    public static void main(String[] args) {
//    	int[] nums = new int[200];
//    	for (int i=0; i<nums.length; i++)
//    		nums[i] = i;
    	int[] nums = new int[] {-6,10,18};
    	ShuffleArray2 s = new ShuffleArray2(nums);
    	System.out.println("reset:" + Arrays.toString(s.reset()));
    	System.out.println("shuff:" + Arrays.toString(s.shuffle()));
    	System.out.println("reset:" + Arrays.toString(s.reset()));
    	System.out.println("shuff:" + Arrays.toString(s.shuffle()));
    	System.out.println("reset:" + Arrays.toString(s.reset()));

	}
    
}
