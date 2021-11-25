package competitive.mit.minWindow;

import java.util.HashMap;
import java.util.Map;

public class SubSequenceFinder {

	private class WindowInfo {
		int start, length;

		WindowInfo(int s, int l) {
			start = s;
			length = l;
			
		}
		
		@Override
		public String toString() {
			return "" + start + ":" + (start+length);
		}
	}

	private Map<String, WindowInfo> memo = new HashMap<>();

	private WindowInfo find(char[] s, char[] t, int posS, int posT, int windowStart) {
		
		String key = posS + "_" + posT + "_" + windowStart;
		
		// memo
		WindowInfo info = memo.get(key);
		if (info  != null)
			return info;
		
		// base case
		if (posT == t.length) {
			WindowInfo solution = new WindowInfo(windowStart, posS - windowStart);
			memo.put(key, solution);			
			return solution;
		}
		int remainsInS = s.length - posS;
		int remainsInT = t.length - posT;
		if (remainsInS < remainsInT) {
			memo.put(key, null);	
			return null;
		}
		
		// sub-problem
		// use currentPosition
		WindowInfo option1;
		if (s[posS] == t[posT]) {
			option1 = find(s, t, posS + 1, posT + 1, posT == 0 ? posS : windowStart);
		} else {
			option1 = find(s, t, posS + 1, posT, windowStart);
		}
		// skip currentPosition
		WindowInfo option2 = find(s, t, posS + 1, posT, windowStart);

		WindowInfo solution;
		if (option1 == null)
			solution = option2;
		else if (option2 == null)
			solution = option1;
		else if (option1.length == option2.length)
			solution = (option1.start < option2.start) ? option1 : option2;
		else
			solution = option1.length < option2.length ? option1 : option2;
		memo.put(key, solution);
		return solution;
	}

	public String find(String s, String t) {
		System.out.println(find(s.toCharArray(), t.toCharArray(), 0, 0, -1));
		System.out.println(memo.size());
		return null;
	}
	
	public static void main(String[] args) {
		new SubSequenceFinder().find("ABXAXYBY", "XY");
	}

}
