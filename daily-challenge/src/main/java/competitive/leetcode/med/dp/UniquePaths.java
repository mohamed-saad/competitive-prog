package competitive.leetcode.med.dp;

public class UniquePaths {
	
	private Integer[][] memo;
    public int findUniquePaths(int m, int n) {
    	if (m == 0 || n == 0) return 0;	// out of boundries
    	if (memo[m-1][n-1] != null) return memo[m-1][n-1];
    	memo[m-1][n-1] =
    			findUniquePaths(m, n-1)	// move right
    			+ findUniquePaths(m-1, n) ;	// move down
    	return memo[m-1][n-1];
    }
    
    public int uniquePaths(int m, int n) {
    	memo = new Integer[m][n];
    	memo[0][0] = 1;	// base case
    	return findUniquePaths(m, n);
    }
    
    public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(3, 7));
	}
    
}
