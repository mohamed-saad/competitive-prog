package competitive.mit.minWindow;

import java.util.Arrays;

public class Solution {

	String minWindow(char[] S, char[] T) {
        int s = S.length;
        int t = T.length;
        
        int[][] dp = new int[s][t]; 
        
        for(int i = 0; i < s; i++) {
            if(S[i] == T[0]) {
                dp[i][0] = i;
            } else {
                if(i != 0) {
                    dp[i][0] = dp[i-1][0];
                }
            }
        }
        for(int i = 1; i < s; i++) {
            for(int j = 1; j < t; j++) {
                if(S[i] == T[j]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        System.out.println(Arrays.deepToString(dp));
        return null;
	}
	
	public static void main(String[] args) {
		new Solution().minWindow("ABXAXBY".toCharArray(), "XY".toCharArray());
	}
}
