package competitive.leetcode.med.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	private static final int INFINITY = Integer.MAX_VALUE;
	private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int findCoinChange(int[] coins, int amount) {
    	Integer m = memo.get(amount);
    	if (m != null) return m;
    	int min = INFINITY;
    	for (int c: coins) {	// pick one coin from each type
    		int remains = amount-c;
    		if (remains < 0) continue;
    		int v = findCoinChange(coins, remains);	// one coin consumed in the current call
    		if (v < min) min = v;
    	}
    	int change = min == INFINITY ? 
    			  INFINITY
    			: min + 1; // one coin consumed in the current call;
    	memo.put(amount, change);
    	return change;
    }

    
    public int coinChange(int[] coins, int amount) {
    	if (amount == 0) return 0;
    	for (int c: coins) 
    		memo.put(c, 1);	// base case for using 1 coin
    	int change = findCoinChange(coins, amount);
    	if (change == INFINITY) return -1;
    	return change;
    }
    
    public static void main(String[] args) {
		System.out.println(new CoinChange().coinChange(new int[] {3,2,5}, 0));
	}
}
