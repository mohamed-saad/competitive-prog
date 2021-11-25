package competitive.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

public class BestBuy {
	
   private static final int NONE = -1;
   private Map<String, Integer> memo = new HashMap<>();
   private int bestBuy(int[] prices, int day, int lastPurchasePrice) {
		if (day >= prices.length) return 0;
		String key = day + "," + lastPurchasePrice;
		Integer pre = memo.get(key);
		if (pre != null) return pre; 
		
		// at any given day I can
		// skip
		int profitSkip = bestBuy(prices, day+1, lastPurchasePrice);
		// sell
		int profitSell = 
				lastPurchasePrice == NONE ? 
						Integer.MIN_VALUE :
						(prices[day] - lastPurchasePrice) + bestBuy(prices, day+1, NONE); // I have something to sell
		// buy
		int profitBuy = 
				lastPurchasePrice == NONE ? 
						bestBuy(prices, day+1, prices[day]) :	// I have no shares now 
						(prices[day] - lastPurchasePrice) + bestBuy(prices, day+1, prices[day]); // I have to sell my shares first
						
		int best = Math.max(profitSkip, Math.max(profitSell, profitBuy));
		memo.put(key, best);
		return best;
	}

    public int maxProfit(int[] prices) {
        int best = bestBuy(prices, 0, NONE);
        return best;
    }
	
	public static void main(String[] args) {
		int[] prices = new int[] {1,2,2,2,1,10};

//		int[] prices = new int[] {7,1,5,3,6,4};
//		int[] prices = new int[] {1,2,3,4,5};
//		int[] prices = new int[] {7,6,4,3,1};

		int profit = new BestBuy().maxProfit(prices);
		System.out.println(profit);
	}

}
