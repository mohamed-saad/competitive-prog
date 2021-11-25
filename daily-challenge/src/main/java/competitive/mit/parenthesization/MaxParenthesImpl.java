package competitive.mit.parenthesization;

import java.util.HashMap;
import java.util.Map;

public class MaxParenthesImpl implements MaxParenthes {
	
	int calls = 0;
	
	private Map<String, Integer> memo = new HashMap<>();
	
	private int optimize(boolean maximize, char[] equation, int from, int to) {
		String key = maximize + "_" + from + "_" + to;
		Integer memoValue = memo.get(key);
		if (memoValue != null) return memoValue;
		
		calls++;
		if (from == to) return Integer.parseInt(String.valueOf(equation[from]));
		
		int bestValue = maximize ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		
		// try each oprator in that range
		for (int i=from+1; i<to; i+=2) {
			char operator = equation[i];
			int leftValueMax = optimize(maximize, equation, from, i-1);
			int rightValueMax = optimize(maximize, equation, i+1, to);
			int leftValueMin = optimize(!maximize, equation, from, i-1);
			int rightValueMin = optimize(!maximize, equation, i+1, to);
			
			int[] values = new int[4];
			if (operator == '+') {
				values[0] = leftValueMax + rightValueMax;
				values[1] = leftValueMin + rightValueMax;
				values[2] = leftValueMax + rightValueMin;
				values[3] = leftValueMin + rightValueMin;
			} else {
				values[0] = leftValueMax * rightValueMax;
				values[1] = leftValueMin * rightValueMax;
				values[2] = leftValueMax * rightValueMin;
				values[3] = leftValueMin * rightValueMin;
			}
			
			for (int v=0; v<values.length; v++) {
				if (values[v] > bestValue && maximize || values[v] < bestValue && !maximize) bestValue = values[v];
			}
		}
		
		memo.put(key, bestValue);
		return bestValue;
	}
	
	
	@Override
	public int evaluate(char[] equation) {
		int max =  optimize(true, equation, 0, equation.length-1);
		System.out.println("Calls: " + calls);
		return max;
	}

	
}
