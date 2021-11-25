package competitive.mit.lis;

import java.util.HashMap;
import java.util.Map;

public class LISImpl implements LIS {

	private Map<Character, String> memo = new HashMap<>();
	private int calls = 0;
	
	private String getLongestIncreasingSequenceStartingWith(char start, char[] input, int pos) {
		String memorized = memo.get(start);
		if (memorized != null) return memorized;
		calls ++;
		
		String max = "";
		for (int i=pos+1; i<input.length; i++) {
			char next = input[i];
			if (next <= start) continue;
			String lis = getLongestIncreasingSequenceStartingWith(next, input, i);
			if (max.length() < lis.length()) max = lis;
		}

		String maxLis = start + "" + max;
		memo.put(start, maxLis);
		return maxLis;
		
		
	}
	
	@Override
	public String getLongestIncreasingSequence(char[] input) {
		String max = "";
		for (int i=0; i<input.length; i++) {
			String lis = getLongestIncreasingSequenceStartingWith(input[i], input, i);
			if (max.length() < lis.length()) max = lis;
		}
		System.out.println("calls = " + calls);
		return max;
	}

}
