package competitive.leetcode.med.array;

public class IncreasingTripletSubsequence {
	
    public boolean increasingTriplet(int[] nums) {
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
        	if (nums[i] <= min)
        		min = nums[i];
        	else if (nums[i] <= max)
        		max = nums[i];
        	else return true;
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[] {8, 1, 1, 1, 1, 3}));
	}
}
