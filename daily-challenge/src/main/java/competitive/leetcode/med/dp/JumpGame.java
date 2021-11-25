package competitive.leetcode.med.dp;

public class JumpGame {
	
	private Boolean[] memo;
	private boolean canJump(int[] nums, int from) {
		if (from >= nums.length) return false;
		if (from == nums.length-1) {
			return true;
		}
		if (memo[from] != null) return memo[from];
		int jumps = nums[from];
		for (int j=1; j<=jumps; j++) {
			if (canJump(nums, from+j)) {
				memo[from] = true;
				return memo[from];
			}
		}
		memo[from] = false;
		return memo[from];
    }

    public boolean canJump(int[] nums) {
    	memo = new Boolean[nums.length];
    	boolean result = canJump(nums, 0);
    	return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(new JumpGame().canJump(new int[] {2,3,1,1,4}));
    	System.out.println(new JumpGame().canJump(new int[] {3,2,1,0,4}));
		System.out.println(new JumpGame().canJump(new int[] {2,0,3,0,0,4,0,1,0,2,1}));
	}
}
