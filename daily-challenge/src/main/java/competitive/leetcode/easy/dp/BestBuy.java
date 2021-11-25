package competitive.leetcode.easy.dp;

public class BestBuy {

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = prices[0];
		for (int i=1; i<prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i]; 
			}
			int profit = prices[i] - minPrice; 
			if (maxProfit < profit) maxProfit = profit;
		}
		return maxProfit;
	}
	
    public static void main(String[] args) {
    	BestBuy bestBuy = new BestBuy();
		System.out.println(bestBuy.maxProfit(new int[] {7,1,5,3,6,4}));
	}
}
