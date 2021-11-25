package competitive.leetcode.easy.dp;

public class HouseRobber {

	private Integer[] memo;
	private int rob(int[] nums, int current) {
		if (current >= nums.length) return 0;
		if (memo[current] != null) return memo[current];
		// option 1: rob current, skip next
		int money1 = nums[current] + rob(nums, current+2);
		// option 2: skip current, rob next
		int money2 = rob(nums, current+1);
		memo[current] = Math.max(money1, money2);
		return memo[current];
	}
	
	public int rob(int[] nums) {
		memo = new Integer[nums.length];
		memo[nums.length-1] = nums[nums.length-1];
        return rob(nums, 0);
    }
	
	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[] {1,2,3,1}));
	}
}
