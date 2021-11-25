package competitive.mit.altCoin;

import java.util.LinkedList;
import java.util.List;

public class AltCoinImpl1 implements AltCoin {

	private Integer[][] memo;
	private int calls;
	
	public int findBest(int[] coins, int from, int to, List<Integer> plays) {
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
				return memo[from][to] = coins[from];
			} else {
				plays.add(coins[to]);
				return memo[from][to] = coins[to];
			}
		}

		// assume I took the from
		List<Integer> plays1 = new LinkedList<>();
		int option1;
		if (coins[from+1] > coins[to]) {
			option1 = coins[from] + findBest(coins, from+2, to, plays1);
		} else {
			option1 = coins[from] + findBest(coins, from+1, to-1, plays1);
		}

		// assume I took the to
		int option2;
		List<Integer> plays2 = new LinkedList<>();
		if (coins[to-1] > coins[from]) {
			option2 = coins[to] + findBest(coins, from, to-2, plays2);
		} else {
			option2 = coins[to] + findBest(coins, from+1, to-1, plays2);
		}

		if (option1 > option2) {
			plays.add(coins[from]);
			plays.addAll(plays1);
			return memo[from][to] = option1;
		} else {
			plays.add(coins[to]);
			plays.addAll(plays2);
			return memo[from][to] = option2;
		}
	}
	
	@Override
	public List<Integer> findBest(int[] coins) {
		memo = new Integer[coins.length][coins.length];
		List<Integer> plays = new LinkedList<>();
		int x = findBest(coins, 0, coins.length-1, plays);
		System.out.println("best " + x);
		System.out.println("calls " + calls);
		return plays;
	}

	
}
