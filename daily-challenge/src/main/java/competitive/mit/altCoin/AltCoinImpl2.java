package competitive.mit.altCoin;

import java.util.LinkedList;
import java.util.List;

public class AltCoinImpl2 implements AltCoin {

	private Integer[][] memo;
	private int calls;
	
	public int findBest(int[] coins, int from, int to, List<Integer> plays, boolean myTurn) {
		if (memo[from][to] != null) return memo[from][to];
		
		calls++;
		if (from > to) return 0;
		if (from == to) {
			plays.add(coins[from]);
			return memo[from][to] = from;
		}
		if (from == to-1) {
			if (coins[from] > coins[to]) {
				plays.add(coins[from]);
				return coins[from];
			} else {
				plays.add(coins[to]);
				return coins[to];
			}
		}

		if (myTurn) {
			int option1 = coins[from] + findBest(coins, from+1, to, plays, !myTurn);
			int option2 = coins[to] + findBest(coins, from, to-1, plays, !myTurn);
			if (option1 < option2) {
				plays.add(coins[to]);
				return option2;
			} else {
				plays.add(coins[from]);
				return option1;
			}
		} else {
			int o1 = findBest(coins, from+1, to, plays, !myTurn);
			int o2 = findBest(coins, from, to-1, plays, !myTurn);
			int option1 = -1 * coins[from] + o1;
			int option2 = -1 * coins[to] + o2;
			if (option1 > option2) {
				return o2;
			} else {
				return o1;
			}
		}
		
		
	}
	
	@Override
	public List<Integer> findBest(int[] coins) {
		memo = new Integer[coins.length][coins.length];
		List<Integer> plays = new LinkedList<>();
		int x = findBest(coins, 0, coins.length-1, plays, true);
		System.out.println("best " + x);
		System.out.println("calls " + calls);
		return plays;
	}

	
}
