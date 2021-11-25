package competitive.leetcode.easy.dp;

import java.util.Arrays;

public class BestBuy2 {

	private Integer[][] memo;
    private int maxProfit(int[] prices, int today, int buyDay) {
    	if (today == prices.length) return -1;
    	if(memo[today][buyDay] != null) return memo[today][buyDay];
    	// option 1: I can skip
    	int profitSkip = maxProfit(prices, today+1, buyDay);
    	// option 2: I can buy today
    	int profitBuy = maxProfit(prices, today+1, today);
    	// option 3: I can sell now if I already bought
    	int profitSell = -1;
    	if (buyDay < prices.length) {
    		profitSell = prices[today] - prices[buyDay];
    	}
    	memo[today][buyDay] = Math.max(Math.max(profitSkip, profitBuy), Math.max(profitSell, 0));
    	return memo[today][buyDay];
    }
    
    public int maxProfit(int[] prices) {
    	memo = new Integer[prices.length][prices.length+1];
        return maxProfit(prices, 0, prices.length);
    }
    
    public static void main(String[] args) {
    	BestBuy2 bestBuy = new BestBuy2();
		System.out.println(bestBuy.maxProfit(new int[] {7,6,4,3,9,8}));
		System.out.println(Arrays.deepToString(bestBuy.memo));
	}
    
}
