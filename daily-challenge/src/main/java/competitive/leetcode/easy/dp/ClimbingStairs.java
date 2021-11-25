package competitive.leetcode.easy.dp;

public class ClimbingStairs {
	
	private Integer[] memo;
	private int count(int n) {
		if (memo[n] != null) return memo[n];
		memo[n] = count(n-1) + count(n-2);
        return memo[n];  
	}
	
    public int climbStairs(int n) {
    	memo = new Integer[n+1];
    	memo[0] = 1;
    	memo[1] = 1;
        return count(n);  
    }
    
    public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(1));
	}
}
