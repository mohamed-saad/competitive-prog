package competitive.leetcode.hard.array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	private class Counter {
		int v;
		Counter(int v) {
			this.v = v;
		}
	}
	
	// FIXME wrong implementation 
    public int longestConsecutive(int[] nums) {
        Map<Integer, Counter> found = new HashMap<>();
        for (int i: nums) {
        	if (found.containsKey(i)) continue;	// visited before
        	Counter before = found.get(i-1);
        	Counter after = found.get(i+1);
        	if (before != null && after != null){ // merge after+before
        		after.v += before.v + 1;
        		found.put(i-1, after);
        		found.put(i, after);
        	} else if (before != null) { // merge with before
        		before.v++;
        		found.put(i, before);
        	} else if (after != null) { // merge with after
        		after.v++;
        		found.put(i, after);
        	}  else {					// home alone
        		found.put(i, new Counter(1));
        	}
        }
        int max = 0;
        for (Counter c: found.values())
        	max = Math.max(max, c.v);
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
	}
}
