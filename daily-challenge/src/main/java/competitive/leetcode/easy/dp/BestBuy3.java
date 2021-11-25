package competitive.leetcode.easy.dp;

import java.util.HashMap;
import java.util.Map;

public class BestBuy3 {

	private Map<String,Integer> memo = new HashMap<String, Integer>();
    private int maxProfit(int[] prices, int today, int buyDay) {
    	if (today == prices.length) return -1;
    	String key = today + "," + buyDay;
    	Integer memoValue = memo.get(key);
    	if(memoValue != null) return memoValue;
    	// option 1: I can skip
    	int profitSkip = maxProfit(prices, today+1, buyDay);
    	// option 2: I can buy today
    	int profitBuy = maxProfit(prices, today+1, today);
    	// option 3: I can sell now if I already bought
    	int profitSell = -1;
    	if (buyDay < prices.length) {
    		profitSell = prices[today] - prices[buyDay];
    	}
    	int best = Math.max(Math.max(profitSkip, profitBuy), Math.max(profitSell, 0));
    	memo.put(key, best);
    	return best;
    }
    
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, prices.length);
    }
    
    public static void main(String[] args) {
    	int[] prices = new int[10000];
    	for (int i=0; i<prices.length; i++)
    		prices[i] = 100000-i;
    	BestBuy3 bestBuy = new BestBuy3();
		System.out.println(bestBuy.maxProfit(prices));
		System.out.println(bestBuy.memo.size());
	}
    
}
